package com.corndel.supportbank.utils.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import kong.unirest.Unirest;

import java.util.Map;

public class CurrencyRequest {

    public Map<String, Double> getLatestRates() throws JsonProcessingException {

        Dotenv dotenv = Dotenv.load();
        String url = "https://openexchangerates.org/api/latest.json?app_id=" + dotenv.get("OPEN_EXCHANGE_RATES_APP_ID");

        String json = Unirest
                .get(url)
                .header("Accept", "application/json")
                .asString()
                .getBody();

        ObjectMapper mapper = new ObjectMapper();

        String ratesJSON = mapper
                .readTree(json)
                .get("rates")
                .toString();

        return mapper.readValue(ratesJSON, new TypeReference<Map<String, Double>>() {
        });
    }

}
