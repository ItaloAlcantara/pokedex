package br.com.mundo.pokemons.treinador.client;

import br.com.mundo.pokemons.treinador.model.dto.PokemonDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("pokemon-ms")
public interface PokemonClient {

    @RequestMapping(method = RequestMethod.GET, value = "/pokemon/{id}")
    PokemonDto localizaPokemonPorId(@PathVariable Long id);
}
