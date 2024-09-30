package com.corndel.supportbank;

import picocli.CommandLine;

@CommandLine.Command(name = "main", subcommands = {Subcommand.class})
public class MainCommand {
    public static void main(String[] args) {
        new CommandLine(new MainCommand()).execute(args);
    }
}


@CommandLine.Command(name = "sub", subcommands = {SecondaryCommand.class})
class Subcommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Sub command is hooked up");
    }
}

@CommandLine.Command(name = "secondary")
class SecondaryCommand implements Runnable {

    @Override
    public void run() {
        System.out.println("Secondary command is hooked up");
    }
}