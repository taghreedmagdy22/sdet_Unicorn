package com.sdet_unicorns.web.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertiesFile {
    private static  final String configurationPath = System.getProperty("user.dir") + "/src/test/resources/configurations.properties";

    public static Properties setConfigurations() throws IOException {
        Properties configProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(configurationPath);
        configProperties.load(inputStream);
        return configProperties;
    }

}
