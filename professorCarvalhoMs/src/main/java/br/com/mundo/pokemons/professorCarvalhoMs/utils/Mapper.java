package br.com.mundo.pokemons.professorCarvalhoMs.utils;

import br.com.mundo.pokemons.professorCarvalhoMs.model.TreinadorPokemon;
import br.com.mundo.pokemons.professorCarvalhoMs.service.TreinadorPokemonDto;

public class Mapper {

    public TreinadorPokemon toEntity(TreinadorPokemonDto dto){
        return TreinadorPokemon.builder()
                .pokemonId(dto.pokemonId())
                .treinadorId(dto.treinadorId())
                .build();
    }
}
