package br.com.mundo.pokemons.treinador.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String apelido;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;

    @ManyToMany(mappedBy="pokemons")
    private List<Treinador> treinadores;

    private Boolean treinando = false;
}
