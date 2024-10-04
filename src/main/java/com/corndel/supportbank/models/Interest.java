package com.corndel.supportbank.models;

public class Interest {

    private final int amount;

    private final int rate;

    private final int years;

    public Interest(int amount, int rate, int years) {
        this.amount = amount;
        this.rate = rate;
        this.years = years;
    }

    public double compound() {
        return amount * Math.pow((1 + rate / 100d), years);
    }

    public double simple() {
        return (rate / 100d * amount) * years + amount;
    }
}
