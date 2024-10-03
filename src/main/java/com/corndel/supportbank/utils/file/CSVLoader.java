package com.corndel.supportbank.utils.file;

import com.corndel.supportbank.models.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CSVLoader implements Loader<Transaction> {
    private final String fileName;

    protected CSVLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Transaction> load() throws IOException {
        Path path = Paths.get("src", "data", "transactions", fileName);
        return Files.readAllLines(path)
                .stream()
                .skip(1)
                .map(Transaction::of)
                .toList();
    }
}
