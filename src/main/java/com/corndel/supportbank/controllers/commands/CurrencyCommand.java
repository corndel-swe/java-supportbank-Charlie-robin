package com.corndel.supportbank.controllers.commands;

import com.corndel.supportbank.models.ExchangeRateRepository;
import picocli.CommandLine;

@CommandLine.Command(name = "convert")
public class CurrencyCommand implements Runnable {
    @CommandLine.Parameters(index = "0")
    private int amount;

    @CommandLine.Parameters(index = "1")
    private String from;

    @CommandLine.Parameters(index = "2")
    private String to;

    @Override
    public void run() {
        ExchangeRateRepository exchangeRate = new ExchangeRateRepository();
        double exchange = exchangeRate.getExchangeRate(from, to);
        System.out.printf("%c%d %s to %s is %c%.2f", exchangeRate.getCurrency(from) ,amount, from, to, exchangeRate.getCurrency(to), amount * exchange);
    }
}
