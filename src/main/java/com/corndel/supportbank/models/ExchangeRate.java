package com.corndel.supportbank.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {
    private String base = "USD";
    private String currency;
    private double rate;

    public ExchangeRate(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "base='" + base + '\'' +
                ", currency='" + currency + '\'' +
                ", rate=" + rate +
                '}';
    }
}
