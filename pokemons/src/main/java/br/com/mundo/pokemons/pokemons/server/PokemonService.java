package br.com.mundo.pokemons.pokemons.server;

import br.com.mundo.pokemons.pokemons.exception.PokemonNotFoundEx;
import br.com.mundo.pokemons.pokemons.mappers.PokemonMapper;
import br.com.mundo.pokemons.pokemons.model.Pokemon;
import br.com.mundo.pokemons.pokemons.model.dto.PokemonDto;
import br.com.mundo.pokemons.pokemons.model.dto.PokemonInputDto;
import br.com.mundo.pokemons.pokemons.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {

    @Autowired
    PokemonRepository pokemonRepository;

    @Autowired
    PokemonMapper mapper;

    public List<Pokemon> listarTodos(){
        return pokemonRepository.findAll();
    }

    public PokemonDto salvar(PokemonInputDto pokemon){
        var pokemonEntity = pokemonRepository.save(mapper.formToEntity(pokemon));
        return mapper.toDto(pokemonEntity);
    }

    public Pokemon localizarPorId(Long id){
        return pokemonRepository.findById(id)
                .orElseThrow( () -> new PokemonNotFoundEx("Pokemon não encontrado!"));
    }


}
