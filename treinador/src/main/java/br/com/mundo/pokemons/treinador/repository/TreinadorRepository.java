package br.com.mundo.pokemons.treinador.repository;

import br.com.mundo.pokemons.treinador.model.Treinador;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinadorRepository extends CrudRepository<Treinador, Long> {
}
