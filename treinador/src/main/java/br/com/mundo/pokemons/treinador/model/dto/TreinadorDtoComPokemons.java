package br.com.mundo.pokemons.treinador.model.dto;

import lombok.Builder;

import java.util.List;

@Builder
public record TreinadorDtoComPokemons(Long id, List<PokemonInputDto> pokemons) {
}
