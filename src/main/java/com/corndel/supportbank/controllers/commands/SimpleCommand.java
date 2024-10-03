package com.corndel.supportbank.controllers.commands;

import picocli.CommandLine;

@CommandLine.Command(name = "simple")
public class SimpleCommand implements Runnable {

    @CommandLine.Parameters(index = "0")
    private int amount;

    @CommandLine.Parameters(index = "1")
    private int rate;

    @CommandLine.Parameters(index = "2")
    private int years;

    @Override
    public void run() {
        double simpleInterest = (rate / 100d * amount) * years + amount;
        System.out.println(simpleInterest);

    }
}
