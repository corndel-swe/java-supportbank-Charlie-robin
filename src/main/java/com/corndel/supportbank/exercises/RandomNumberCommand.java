package com.corndel.supportbank.exercises;

import picocli.CommandLine;

import java.util.Random;

@CommandLine.Command(name = "random")
public class RandomNumberCommand implements Runnable {
    @Override
    public void run() {
        Random random = new Random();
        System.out.println(random.nextInt());
    }
}
