package br.com.mundo.pokemons.professorCarvalhoMs.service;

import br.com.mundo.pokemons.professorCarvalhoMs.repository.TreinadorPokemonRepository;
import br.com.mundo.pokemons.professorCarvalhoMs.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinadorPokemonService {

    @Autowired
    TreinadorPokemonRepository repository;

    @Autowired
    Mapper mapper;

    public void salvar(TreinadorPokemonDto treinadorPokemonDto){
        repository.save(mapper.toEntity(treinadorPokemonDto));
    }
}
