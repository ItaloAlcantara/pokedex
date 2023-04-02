package br.com.mundo.pokemons.treinador.model.dto;

import br.com.mundo.pokemons.treinador.model.Sexo;
import lombok.Builder;

@Builder
public record PokemonInputDto(Long id, String apelido, Sexo sexo) {
}
