package br.com.mundo.pokemons.treinador.service;

import br.com.mundo.pokemons.treinador.model.Pokemon;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PokemonService {
    @Autowired
    private EntityManager entityManager;

    @Transactional
    public Pokemon save(Pokemon pokemon) {
        return entityManager.merge(pokemon);
    }
}