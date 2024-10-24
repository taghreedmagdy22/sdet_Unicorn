package com.sdet_unicorns.web.tests;

import com.sdet_unicorns.web.driver.WebDriverSingleton;

import java.util.Properties;

public class BaseTest {

    protected WebDriverSingleton driver;
    protected static Properties properties;

    public BaseTest(){
        driver = WebDriverSingleton.getDriverSingleton();
    }
}


