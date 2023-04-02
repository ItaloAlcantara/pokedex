package br.com.mundo.pokemons.professorCarvalhoMs.service;

import lombok.Builder;

@Builder
public record TreinadorPokemonDto(Long treinadorId, Long pokemonId) {
}
