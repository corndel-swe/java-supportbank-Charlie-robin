package com.corndel.supportbank.cli.invest;

import com.corndel.supportbank.models.Interest;
import picocli.CommandLine;

@CommandLine.Command(name = "simple")
public class SimpleCommand implements Runnable {

    @CommandLine.Parameters(index = "0", description = "The amount to invest")
    private int amount;

    @CommandLine.Parameters(index = "1", description = "The interest rate")
    private int rate;

    @CommandLine.Parameters(index = "2", description = "The number of years")
    private int years;

    @Override
    public void run() {
        System.out.println("Calculating simple interest for amount: " + amount + ", rate: " + rate + "%, over " + years + " years.");
        Interest interest = new Interest(amount, rate, years);
        System.out.println(interest.compound());
    }
}
