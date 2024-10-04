package com.corndel.supportbank.cli.currency;

import com.corndel.supportbank.models.ExchangeRate;
import com.corndel.supportbank.repositories.ExchangeRateRepository;
import com.corndel.supportbank.utils.api.CurrencyRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import picocli.CommandLine;


// CONFIG : currency latest

@CommandLine.Command(name = "latest")
public class LatestCommand implements Runnable {

    @Override
    public void run() {
        try {
            CurrencyRequest currencyRequest = new CurrencyRequest();
            ExchangeRateRepository exchangeRateRepository = new ExchangeRateRepository(currencyRequest.getLatestRates());

            System.out.println("Printing Latest USD exchange rates");
            exchangeRateRepository.getExchangeRates().forEach(ExchangeRate::print);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        new LatestCommand().run();
    }
}
