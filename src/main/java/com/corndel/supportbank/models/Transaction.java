package com.corndel.supportbank.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {
    @JsonProperty("Date")
    private String date;
    @JsonProperty("FromAccount")
    private String from;
    @JsonProperty("ToAccount")
    private String to;
    @JsonProperty("Narrative")
    private String narrative;
    @JsonProperty("Amount")
    private double amount;

    public Transaction() {
    }

    public Transaction(String date, String from, String to, String narrative, double amount) {
        this.date = date;
        this.from = from;
        this.to = to;
        this.narrative = narrative;
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getNarrative() {
        return narrative;
    }

    public void setNarrative(String narrative) {
        this.narrative = narrative;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean isPartOfTransaction(String name) {
        return to.equalsIgnoreCase(name) || from.equalsIgnoreCase(name);
    }


    public static Transaction of(String[] args) {
        try {
            String date = args[0];
            String from = args[1];
            String to = args[2];
            String narrative = args[3];
            double amount = Double.parseDouble(args[4]);
            return new Transaction(date, from, to, narrative, amount);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Transaction of(String arg) {
        return of(arg.split(","));
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "date='" + date + '\'' +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", narrative='" + narrative + '\'' +
                ", amount=" + amount +
                '}';
    }
}
