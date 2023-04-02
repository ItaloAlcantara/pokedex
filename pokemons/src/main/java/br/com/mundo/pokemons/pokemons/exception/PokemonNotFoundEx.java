package br.com.mundo.pokemons.pokemons.exception;

public class PokemonNotFoundEx extends RuntimeException{
    public PokemonNotFoundEx(String mensagem) {
        super(mensagem);
    }
}
