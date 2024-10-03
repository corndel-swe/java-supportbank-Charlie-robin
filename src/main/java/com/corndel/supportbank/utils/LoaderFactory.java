package com.corndel.supportbank.utils;

import com.corndel.supportbank.models.Transaction;

public class LoaderFactory {
    public static Loader<Transaction> getFileLoader(String fileName) {
        if (fileName.matches("^\\.json")) {
            return new JSONLoader(fileName);
        } else {
            return new CSVLoader(fileName);
        }
    }
}
