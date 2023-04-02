package br.com.mundo.pokemons.pokemons.mappers;


import br.com.mundo.pokemons.pokemons.model.Pokemon;
import br.com.mundo.pokemons.pokemons.model.dto.PokemonDto;
import br.com.mundo.pokemons.pokemons.model.dto.PokemonInputDto;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PokemonMapper {


    public Pokemon toEntity(PokemonDto pokemon) {
        return Pokemon.builder()
                .name(pokemon.name())
                .build();
    }

    public Pokemon formToEntity(PokemonInputDto pokemon) {
        return Pokemon.builder()
                .name(pokemon.name())
                .build();
    }

    public PokemonDto toDto(Pokemon pokemon) {
        return PokemonDto.builder()
                .id(pokemon.getId())
                .name(pokemon.getName())
                .build();
    }
}
