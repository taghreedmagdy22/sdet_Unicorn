package com.sdet_unicorns.web.tests;

import com.sdet_unicorns.web.basis.SdetUnicorns;
import com.sdet_unicorns.web.driver.WebDriverSingleton;

import java.util.Properties;

public class BaseTest {

    protected WebDriverSingleton driver;
    protected static Properties properties;
    protected static SdetUnicorns sdetUnicorns = new SdetUnicorns();


    public BaseTest(){
        driver = WebDriverSingleton.getDriverSingleton();
    }
}


