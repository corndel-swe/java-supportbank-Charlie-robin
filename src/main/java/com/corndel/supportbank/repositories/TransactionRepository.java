package com.corndel.supportbank.repositories;

import com.corndel.supportbank.models.Transaction;
import com.corndel.supportbank.utils.file.Loader;

import java.io.IOException;
import java.util.List;

public class TransactionRepository {

    private final List<Transaction> transactions;

    public TransactionRepository(Loader<Transaction> loader) throws IOException {
            this.transactions = loader.load();
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
}
