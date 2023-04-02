package br.com.mundo.pokemons.pokemons.controller;


import br.com.mundo.pokemons.pokemons.model.dto.PokemonDto;
import br.com.mundo.pokemons.pokemons.model.dto.PokemonInputDto;
import br.com.mundo.pokemons.pokemons.server.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping
    public ResponseEntity listarTodos(){
        return ResponseEntity.ok(pokemonService.listarTodos());
    }

    @PostMapping
    public ResponseEntity salvar(@RequestBody PokemonInputDto pokemon, UriComponentsBuilder uri){
        var created = pokemonService.salvar(pokemon);
        URI location = uri.path("/{id}").buildAndExpand(created.id()).toUri();
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity localizaPorId(@PathVariable Long id){
        System.out.println("EITA");
        return ResponseEntity.ok(pokemonService.localizarPorId(id));
    }


}
