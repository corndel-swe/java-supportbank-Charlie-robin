package com.corndel.supportbank.controllers.commands;


import picocli.CommandLine;

@CommandLine.Command(name = "compound")
public class CompoundCommand implements Runnable {

    @CommandLine.Parameters(index = "0")
    private int amount;

    @CommandLine.Parameters(index = "1")
    private int rate;

    @CommandLine.Parameters(index = "2")
    private int years;

    @Override
    public void run() {
        double compound = amount * Math.pow((1 + rate / 100d), years);
        System.out.println(compound);
    }
}
