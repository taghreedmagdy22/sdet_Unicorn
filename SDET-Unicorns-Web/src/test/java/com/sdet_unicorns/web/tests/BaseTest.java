package com.sdet_unicorns.web.tests;

import com.sdet_unicorns.web.basis.SdetUnicorns;
import com.sdet_unicorns.web.driver.WebDriverSingleton;

import java.util.Properties;

public class BaseTest {

    protected WebDriverSingleton driver;
    protected static Properties sdetUnicornsLink;
    protected static Properties profileDetails;
    protected static Properties productDetails;
    protected static SdetUnicorns sdetUnicorns = new SdetUnicorns();


    public BaseTest(){
        driver = WebDriverSingleton.getDriverSingleton();
    }
}


