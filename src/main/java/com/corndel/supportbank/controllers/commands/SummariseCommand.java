package com.corndel.supportbank.controllers.commands;

import com.corndel.supportbank.models.Transaction;
import com.corndel.supportbank.models.TransactionRepository;
import com.corndel.supportbank.services.TransactionService;
import com.corndel.supportbank.utils.Loader;
import com.corndel.supportbank.utils.LoaderFactory;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command(name = "summarise")
public class SummariseCommand implements Runnable {
    @CommandLine.Parameters(index = "0", defaultValue = "Transactions2014.csv")
    private String fileName;

    @Override
    public void run() {

        try {
            Loader<Transaction> loader = LoaderFactory.getFileLoader(fileName);
            TransactionRepository repository = new TransactionRepository(loader);
            TransactionService service = new TransactionService(repository);
            service.getAccounts().forEach((k, v) -> {
                System.out.println(k);
                System.out.println(" - Current Balance : " + v);
                System.out.println("-".repeat(10));
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
