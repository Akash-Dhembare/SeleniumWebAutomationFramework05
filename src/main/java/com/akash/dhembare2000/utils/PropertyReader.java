package com.akash.dhembare2000.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public PropertyReader() {
    }

    public static String readkey(String Key){
        FileInputStream fileInputStream = null;
        Properties p = null;

        try {
            fileInputStream = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/data.properties");
            p = new Properties();

            p.load(fileInputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return p.getProperty(Key);
    }
}
