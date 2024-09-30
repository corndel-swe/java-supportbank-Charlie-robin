package com.corndel.supportbank.exercises;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "hello", subcommands = {ColorCommand.class})
public class HelloWorld implements Runnable {

    @Parameters(index = "0", defaultValue = "World")
    private String end;

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new HelloWorld());
        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        System.out.printf("Hello, %s!%n", end);
    }
}
