package com.corndel.supportbank.models;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRate {

    private Map<String, Double> exchangeRate;

    public ExchangeRate() {
        exchangeRate = new HashMap<>();
        exchangeRate.put("USD-GBP", .75);
        exchangeRate.put("GBP-USD", 1.34);
    }
}
