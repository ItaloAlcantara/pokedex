package br.com.mundo.pokemons.professorCarvalhoMs.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Calendar;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "treinador_pokemon")
public class TreinadorPokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "id_treinador")
    private Long treinadorId;
    @Column(name= "id_pokemon")
    private Long pokemonId;
    @Column(name = "data_deposito")
    private Calendar dataDeposito;

}
