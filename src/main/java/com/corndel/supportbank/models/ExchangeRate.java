package com.corndel.supportbank.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeRate {
    private final String base = "USD";
    private final String currency;
    private final double rate;

    public ExchangeRate(String currency, double rate) {
        this.currency = currency;
        this.rate = rate;
    }

    public String getBase() {
        return base;
    }

    public String getCurrency() {
        return currency;
    }

    public double getRate() {
        return rate;
    }

    public void print() {
        System.out.printf("%s to %s is %.2f\n", base, currency, rate);
    }

    public void printExchange(double amount) {
        print();
        System.out.printf("%.2f %s to %s is %.2f\n", amount, base, currency, amount * rate);
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
