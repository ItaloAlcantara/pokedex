package br.com.mundo.pokemons.professorCarvalhoMs.repository;

import br.com.mundo.pokemons.professorCarvalhoMs.model.TreinadorPokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinadorPokemonRepository extends CrudRepository<TreinadorPokemon, Long> {
}
