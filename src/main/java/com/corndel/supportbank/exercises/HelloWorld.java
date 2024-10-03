package com.corndel.supportbank.exercises;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "hello")
public class HelloWorld implements Runnable {

    @Parameters(index = "0", defaultValue = "World")
    private String command;

    public static void main(String[] args) {
        CommandLine commandLine = new CommandLine(new HelloWorld());
        int exitCode = commandLine.execute(args);
        System.exit(exitCode);
    }

    @Override
    public void run() {
        if (command.equals("color")) {
            new ColorCommand().run();
        } else if (command.equals("random")) {
            new RandomNumberCommand().run();
        } else {
            System.out.println("Hello, " + command + "!");
        }
    }
}
