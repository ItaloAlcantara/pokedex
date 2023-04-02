package br.com.mundo.pokemons.treinador.service;

import br.com.mundo.pokemons.treinador.client.PokemonClient;
import br.com.mundo.pokemons.treinador.model.Pokemon;
import br.com.mundo.pokemons.treinador.model.Treinador;
import br.com.mundo.pokemons.treinador.model.dto.PokemonInputDto;
import br.com.mundo.pokemons.treinador.model.dto.TreinadorDtoComPokemons;
import br.com.mundo.pokemons.treinador.model.dto.TreinadorInputDto;
import br.com.mundo.pokemons.treinador.repository.PokemonRepository;
import br.com.mundo.pokemons.treinador.repository.TreinadorRepository;
import br.com.mundo.pokemons.treinador.utils.constantes.NameQueuesConst;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TreinadorService {

    @Autowired
    TreinadorRepository treinadorRepository;

    @Autowired
    PokemonClient pokemonClient;

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public List<Treinador> listarTodos(){
        return (List<Treinador>) treinadorRepository.findAll();
    }

    @Transactional
    public Treinador salvar(TreinadorInputDto treinador) {
        List<Pokemon> pokemons = new ArrayList<>();
        if(treinador.pokemons() != null)
            pokemons = getPokemons(treinador);
        return treinadorRepository.save(Treinador.builder()
                                            .name(treinador.name())
                                            .pokemons(pokemons)
                                            .build());
    }

    private List<Pokemon> getPokemons(TreinadorInputDto treinador) {
        return treinador.pokemons()
                .stream()
                .map(this::treinadorInputTakeListPokemonsInputToPokemonEntity)
                .collect(Collectors.toList());
    }

    private Pokemon treinadorInputTakeListPokemonsInputToPokemonEntity(PokemonInputDto pokemon) {
        var pokemonClient = this.pokemonClient.localizaPokemonPorId(pokemon.id());

        return Pokemon.builder()
                .name(pokemonClient.name())
                .sexo(pokemon.sexo())
                .apelido(pokemon.apelido()).build();
    }

    public List<String> enviarParaTreino(TreinadorDtoComPokemons treinador) {
        List<Pokemon> pokemons = pokemonRepository.findAllByTreinadores_Id(treinador.id()).orElse(Collections.emptyList());
        List<TreinadorDtoComPokemons> listaParaMensagem = new ArrayList<>();

        List<String> names = treinador.pokemons().stream()
                .flatMap(pokemon -> pokemons.stream()
                        .filter(p -> Objects.equals(p.getId(), pokemon.id()))
                        .peek(p -> {
                            p.setTreinando(true);
                            listaParaMensagem.add(criarMensagemParaTreinador(treinador, p));
                        })
                        .map(Pokemon::getName)
                )
                .collect(Collectors.toList());

        pokemonRepository.saveAll(pokemons);
        listaParaMensagem.forEach(mensagem -> {
            String message = String.format("Treinador %s envia o(s) Pokémon(s): %s", treinador.id(), mensagem.pokemons());
            rabbitTemplate.convertAndSend(NameQueuesConst.ENVIO_CONCLUIDO.name(), message);
        });

        return names;
    }

    private TreinadorDtoComPokemons criarMensagemParaTreinador(TreinadorDtoComPokemons treinador, Pokemon pokemon) {
        return TreinadorDtoComPokemons.builder()
                .id(treinador.id())
                .pokemons(Collections.singletonList(PokemonInputDto.builder().id(pokemon.getId()).build()))
                .build();
    }
}
