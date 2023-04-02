package br.com.mundo.pokemons.treinador.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Generated;

import java.util.List;

@Entity(name = "treinador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Treinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(cascade =CascadeType.ALL)
    @JoinTable(
            name = "treinador_pokemons",
            joinColumns = @JoinColumn(name = "treinador_id"),
            inverseJoinColumns = @JoinColumn(name = "pokemon_id"))
    private List<Pokemon> pokemons;

}
