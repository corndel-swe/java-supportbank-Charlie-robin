package com.corndel.supportbank.examples;

import java.io.FileNotFoundException;

public class Sandbox {

    public static void main(String[] args) {
        try {
            throw new FileNotFoundException();
        } catch (FileNotFoundException e) {
            System.out.println();
        } catch (RuntimeException e) {
            System.out.println(e.getClass());
            throw new RuntimeException(e);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
