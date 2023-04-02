package br.com.mundo.pokemons.pokemons;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PokemonsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PokemonsApplication.class, args);
	}

}
