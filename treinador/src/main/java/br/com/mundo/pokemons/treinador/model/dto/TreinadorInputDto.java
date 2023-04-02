package br.com.mundo.pokemons.treinador.model.dto;

import java.util.List;

public record TreinadorInputDto(String name, List<PokemonInputDto> pokemons) {
}
