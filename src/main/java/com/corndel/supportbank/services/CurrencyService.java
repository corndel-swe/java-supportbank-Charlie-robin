package com.corndel.supportbank.services;

import picocli.CommandLine;

@CommandLine.Command(name = "convert")
public class CurrencyService implements Runnable {
    @CommandLine.Parameters(index = "0")
    private int amount;

    @CommandLine.Parameters(index = "1")
    private String from;

    @CommandLine.Parameters(index = "2")
    private String to;

    @Override
    public void run() {
    }
}
