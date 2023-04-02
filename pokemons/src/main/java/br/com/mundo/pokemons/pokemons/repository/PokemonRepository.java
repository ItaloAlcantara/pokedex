package br.com.mundo.pokemons.pokemons.repository;

import br.com.mundo.pokemons.pokemons.model.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
}

