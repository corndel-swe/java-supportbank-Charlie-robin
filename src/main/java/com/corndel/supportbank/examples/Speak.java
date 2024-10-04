package com.corndel.supportbank.examples;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.Arrays;

@Command(name = "speak", subcommands = LoudController.class)
public class Speak implements Runnable {

    @Parameters(index = "0", defaultValue = "Default Message")
    protected String toSpeak;

    public Speak() {
        System.out.println(this.getClass().getSimpleName());
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(args));
        new CommandLine(new Speak()).execute(args);
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + " " + toSpeak);
    }
}


@Command(name = "loud", subcommands = RepeatService.class)
class LoudController implements Runnable {

    @Parameters(index = "0", defaultValue = "Default Message")
    protected String toSpeak;

    public LoudController() {
        System.out.println(this.getClass().getSimpleName());
    }

    @Override
    public void run() {
        System.out.println(this.getClass().getSimpleName() + " " + toSpeak);
    }
}

@Command(name = "repeat")
class RepeatService implements Runnable {

    @Parameters(index = "0", defaultValue = "Default Message")
    protected String toSpeak;

    @Parameters(index = "1")
    protected int repeatTimes;

    public RepeatService() {
        System.out.println(this.getClass().getSimpleName());
    }

    @Override
    public void run() {
        for (int i = 0; i < repeatTimes; i++) {
            System.out.println(this.getClass().getSimpleName() + " " + toSpeak);
        }
    }
}

