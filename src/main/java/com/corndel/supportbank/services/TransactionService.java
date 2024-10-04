package com.corndel.supportbank.services;

import com.corndel.supportbank.models.Transaction;
import com.corndel.supportbank.repositories.TransactionRepository;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionService {

    private final TransactionRepository repository;

    public TransactionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public Map<String, Double> getAccounts() throws IOException {
        Map<String, Double> accounts = new HashMap<>();

        repository.getTransactions().forEach(transaction -> {
            accounts.compute(transaction.getFrom(), (k, v) -> v == null ? 0 - transaction.getAmount() : v - transaction.getAmount());
            accounts.compute(transaction.getTo(), ((k, v) -> v == null ? transaction.getAmount() : v + transaction.getAmount()));
        });

        return accounts;
    }


    public List<Transaction> getTransactionsByName(String name) {

        return repository.getTransactions()
                .stream()
                .filter(t -> t.isPartOfTransaction(name))
                .toList();
    }

}
