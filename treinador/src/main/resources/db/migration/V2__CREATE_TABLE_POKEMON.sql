CREATE TABLE pokemon (
    id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    apelido VARCHAR(255),
    sexo VARCHAR(255),
    treinando BOOLEAN DEFAULT FALSE
);

