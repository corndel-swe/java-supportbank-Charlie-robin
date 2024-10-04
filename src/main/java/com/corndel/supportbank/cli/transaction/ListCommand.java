package com.corndel.supportbank.cli.transaction;

import com.corndel.supportbank.models.Transaction;
import com.corndel.supportbank.repositories.TransactionRepository;
import com.corndel.supportbank.services.TransactionService;
import com.corndel.supportbank.utils.file.Loader;
import com.corndel.supportbank.utils.file.LoaderFactory;
import picocli.CommandLine;

import java.io.IOException;

@CommandLine.Command(name = "list")
public class ListCommand implements Runnable {
    @CommandLine.Parameters(index = "1", defaultValue = "Transactions2014.csv")
    private String fileName;

    @CommandLine.Parameters(index = "0")
    private String name;

    @Override
    public void run() {
        try {
            Loader<Transaction> loader = LoaderFactory.getFileLoader(fileName);
            TransactionRepository repository = new TransactionRepository(loader);
            TransactionService service = new TransactionService(repository);
            service.getTransactionsByName(name)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
