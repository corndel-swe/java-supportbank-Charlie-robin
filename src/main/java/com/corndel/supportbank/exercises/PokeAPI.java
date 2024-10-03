package com.corndel.supportbank.exercises;

// import kong.unirest.Unirest;

// import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

import java.util.List;

/**
 * This class represents a Pokemon. It uses Java's record syntax to
 * automatically generate a class with getters and utility methods.
 * See this url for more info:
 * https://www.baeldung.com/java-record-keyword
 */

@JsonIgnoreProperties(ignoreUnknown = true)
record Pokemon(Integer id, String name, Integer height, Integer weight) {
}

public class PokeAPI {
    /**
     * Get a Pokemon by its name.
     * <p>
     * Makes a GET request to the PokeAPI, and uses Jackson to parse the JSON
     * response into a Pokemon object.
     *
     * @param name The name of the Pokemon to retrieve.
     * @return The Pokemon object.
     */
    public static Pokemon getPokemonByName(String name) throws Exception {
        // TODO: Create the url by appending the name to the base url
        String url = "https://pokeapi.co/api/v2/pokemon/" + name;
        // TODO: Make a GET request to the url
        // Hint: Use Unirest.get()
        HttpResponse<String> response = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString();

        String json = response.getBody();

        // TODO: Parse the response body into a Pokemon object
        // Hint: Use Jackson's ObjectMapper to map the response body to Pokemon.class
        ObjectMapper mapper = new ObjectMapper();
        // TODO: Return the Pokemon
        return mapper.readValue(json, Pokemon.class);
    }

    public static List<Pokemon> getALlPokemon() throws JsonProcessingException {
        String url = "https://pokeapi.co/api/v2/pokemon?limit=100";

        HttpResponse<String> response = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString();

        String json = response.getBody();

        ObjectMapper mapper = new ObjectMapper();

        String results = mapper.readTree(json)
                .get("results")
                .toString();

        return mapper.readValue(results, new TypeReference<List<Pokemon>>() {});
    }

    /**
     * For debugging purposes..
     */
    public static void main(String[] args) {
        try {
            getALlPokemon().forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
