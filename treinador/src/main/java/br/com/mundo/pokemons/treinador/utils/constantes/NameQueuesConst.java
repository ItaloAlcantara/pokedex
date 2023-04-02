package br.com.mundo.pokemons.treinador.utils.constantes;

import lombok.Getter;

@Getter
public enum NameQueuesConst {

    ENVIO_CONCLUIDO("envio.concluido");

    final String value;

    NameQueuesConst(String value){
        this.value = value;
    }



}
