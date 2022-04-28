package com.daniel.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class URL {
    public static Map<String, HashMap> configData;
    private static final String configFileName = "config.json";

    public static String getTestPageURL(String testPage) {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource res = new Resource();
        String finalTestingUrl;
        try {
            if(configData == null) {
                InputStream inputStream = res.getFileFromResourceAsStream(configFileName);
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

                configData = objectMapper.readValue(bufferedReader, HashMap.class);

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
            }
            String sitePath = configData.get(testPage).get("path").toString();
            finalTestingUrl = configData.get("BASE_HOST").get("url").toString().concat(sitePath);

        } catch(Exception ex) {
            throw new RuntimeException("ERR | issue when reading the testing url from json data file!");
        }

        return finalTestingUrl;
    }
}
