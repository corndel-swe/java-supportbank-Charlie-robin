package com.corndel.supportbank.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExchangeRateRepository {

    private final Map<String, Double> exchangeRates;

    public ExchangeRateRepository(Map<String, Double> exchangeRates) {
        this.exchangeRates = exchangeRates;
    }

    public ExchangeRate getExchangeRate(String rate) throws IllegalArgumentException {
        if (!exchangeRates.containsKey(rate)) {
            throw new IllegalArgumentException(rate + " : RATE does not exist");
        }

        return new ExchangeRate(rate, exchangeRates.get(rate));
    }

    public List<ExchangeRate> getExchangeRates() {
        List<ExchangeRate> rates = new ArrayList<>();
        exchangeRates.forEach((k, v) -> rates.add(new ExchangeRate(k, v)));
        return rates;
    }
}
