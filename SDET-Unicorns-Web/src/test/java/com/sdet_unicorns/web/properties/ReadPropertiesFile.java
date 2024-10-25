package com.sdet_unicorns.web.properties;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


public class ReadPropertiesFile {
    private static  final String homePath = System.getProperty("user.dir") + "/src/test/resources/configurations.properties";
    private static  final String profilePath = System.getProperty("user.dir") + "/src/test/resources/profile.properties";


    public static Properties setHomeProperties() throws IOException {
        Properties homeProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(homePath);
        homeProperties.load(inputStream);
        return homeProperties;
    }

    public static Properties setProfileDetails() throws IOException {
        Properties profileProperties = new Properties();
        FileInputStream inputStream = new FileInputStream(profilePath);
        profileProperties.load(inputStream);
        return profileProperties;
    }

}
