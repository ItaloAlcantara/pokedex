CREATE TABLE IF NOT EXISTS treinador_pokemons (
    treinador_id BIGINT NOT NULL,
    pokemon_id BIGINT NOT NULL,
    CONSTRAINT pk_treinador_pokemons PRIMARY KEY (treinador_id, pokemon_id),
    CONSTRAINT fk_treinador_pokemons_treinador FOREIGN KEY (treinador_id) REFERENCES treinador(id),
    CONSTRAINT fk_treinador_pokemons_pokemon FOREIGN KEY (pokemon_id) REFERENCES pokemon(id)
);