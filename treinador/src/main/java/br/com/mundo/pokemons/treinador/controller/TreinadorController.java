package br.com.mundo.pokemons.treinador.controller;

import br.com.mundo.pokemons.treinador.model.dto.TreinadorDtoComPokemons;
import br.com.mundo.pokemons.treinador.model.dto.TreinadorInputDto;
import br.com.mundo.pokemons.treinador.service.TreinadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/treinador")
public class TreinadorController {

    @Autowired
    TreinadorService treinadorService;

    @GetMapping
    public ResponseEntity listarTodos(){
        return ResponseEntity.ok(treinadorService.listarTodos());
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody TreinadorInputDto treinador, UriComponentsBuilder uri){
        var created = treinadorService.salvar(treinador);
        URI location = uri.path("/{id}").buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    @Transactional
    public ResponseEntity enviandoParaTreino(@RequestBody TreinadorDtoComPokemons treinador){
        var pokemons = treinadorService.enviarParaTreino(treinador);
        return ResponseEntity.ok(pokemons);
    }

}
