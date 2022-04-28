package com.daniel.utils;

import java.io.InputStream;

public class Resource {
    public InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader loader = getClass().getClassLoader();
        InputStream inputStream = loader.getResourceAsStream(fileName);

        if(inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

}
