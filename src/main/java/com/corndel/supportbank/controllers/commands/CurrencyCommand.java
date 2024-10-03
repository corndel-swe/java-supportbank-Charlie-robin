package com.corndel.supportbank.controllers.commands;

import com.corndel.supportbank.models.ExchangeRate;
import com.corndel.supportbank.models.ExchangeRateRepository;
import com.corndel.supportbank.utils.api.CurrencyRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import picocli.CommandLine;

// currency convert 100 USD GBP

@CommandLine.Command(name = "convert")
public class CurrencyCommand implements Runnable {
    @CommandLine.Parameters(index = "0")
    private double amount;

    @CommandLine.Parameters(index = "1")
    private String from;

    @CommandLine.Parameters(index = "2")
    private String to;

    @Override
    public void run() {
        try {
            if (!from.equalsIgnoreCase("USD")) {
                throw new IllegalArgumentException("from can only be USD, " + from + " is not excepted.");
            }

            CurrencyRequest currencyRequest = new CurrencyRequest();
            ExchangeRateRepository exchangeRateRepository = new ExchangeRateRepository(currencyRequest.getLatestRates());
            ExchangeRate exchangeRate = exchangeRateRepository.getExchangeRate(to.toUpperCase());

            System.out.println("Printing rate and conversion");
            exchangeRate.printExchange(amount);

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
