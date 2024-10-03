package com.corndel.supportbank.utils;

import java.io.IOException;
import java.util.List;

public interface Loader<T>{
    List<T> load() throws IOException;
}
