package com.corndel.supportbank.models;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRateRepository {

    private final Map<String, Double> exchangeRate;
    private final Map<String, Character> currency;

    public ExchangeRateRepository() {
        exchangeRate = new HashMap<>();
        exchangeRate.put(getKey("USD", "GBP"), .75);
        exchangeRate.put(getKey("GBP", "USD"), 1.34);
        currency = new HashMap<>();
        currency.put("GBP", '£');
        currency.put("USD", '$');
    }

    public Character getCurrency(String country) {
        return currency.get(country);
    }

    public double getExchangeRate(String from, String to) {
        return getExchangeRate(getKey(from, to));
    }

    public double getExchangeRate(String key) {
        return exchangeRate.getOrDefault(key, 0d);
    }

    private String getKey(String from, String to) {
        return from + "-" + to;
    }
}
