package br.com.mundo.pokemons.treinador.repository;

import br.com.mundo.pokemons.treinador.model.Pokemon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    Optional<List<Pokemon>> findAllByTreinadores_Id(Long id);
}
