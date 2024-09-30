package com.corndel.supportbank.exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Adder {
    /**
     * This method reads a file line by line and adds up the numbers on each line.
     * It uses try/catch to print "Something went wrong" and
     * returns 0 in case of an exception.
     *
     * @param fileName The name of the file to be read.
     * @return The sum of the numbers in the file.
     */
    public int add(String fileName) {
        // TODO: Read the file
        // Hint: Use Paths.get() and Files.readAllLines()
        Path path = Paths.get("src", "data", fileName);
        // TODO: Add up the numbers
        // Hint: Use a loop
        // Hint: Use Integer.parseInt
        try {
            return Files.readAllLines(path)
                    .stream()
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (IOException e) {
            return 0;
        }
        // TODO: Return the sum
    }

    /**
     * Calls the add method and prints the result.
     * This method is for debugging purposes only.
     */
    public static void main(String[] args) {
        Adder adder = new Adder();
        System.out.println(adder.add("nums.txt"));
    }
}
