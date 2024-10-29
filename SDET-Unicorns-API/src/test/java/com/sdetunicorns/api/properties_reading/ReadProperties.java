package com.sdetunicorns.api.properties_reading;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class  ReadProperties {

    private static final String apiBasisPath = "src/test/resources/configuration.properties";

    public static Properties setProperties() throws IOException {
        Properties configurationProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(apiBasisPath);
        configurationProperties.load(inputStream);
        return configurationProperties;
    }

}