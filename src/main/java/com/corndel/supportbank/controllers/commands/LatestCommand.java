package com.corndel.supportbank.controllers.commands;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;
import picocli.CommandLine;

import java.util.Map;

@CommandLine.Command(name = "latest")
public class LatestCommand implements Runnable {

    @Override
    public void run() {
        Dotenv dotenv = Dotenv.load();
        String url = "https://openexchangerates.org/api/latest.json?app_id=" + dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");

        var response = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString();

        String json = response.getBody();

        ObjectMapper mapper = new ObjectMapper();
        try {
            String rates = mapper.readTree(json).get("rates").toString();
            System.out.println(mapper.readValue(rates, new TypeReference<Map<String, Double>>() {
            }));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        new LatestCommand().run();
    }
}
