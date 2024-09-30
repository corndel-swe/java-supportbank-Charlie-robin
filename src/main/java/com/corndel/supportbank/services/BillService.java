package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Bill;
import picocli.CommandLine;

@CommandLine.Command(name = "split")
public class BillService implements Runnable {

    @CommandLine.Parameters(index = "0")
    private double price;

    @CommandLine.Parameters(index = "1")
    private double people;


    @Override
    public void run() {
        Bill bill = new Bill(price);
        System.out.println(bill.split(people));
    }
}
