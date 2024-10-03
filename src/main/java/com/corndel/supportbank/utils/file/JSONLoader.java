package com.corndel.supportbank.utils.file;

import com.corndel.supportbank.models.Transaction;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JSONLoader implements Loader<Transaction> {

    private final String fileName;

    public JSONLoader(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public List<Transaction> load() throws IOException {
        File file = Paths.get("src", "data", "transactions", fileName).toFile();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(file, new TypeReference<>() {});
    }
}
