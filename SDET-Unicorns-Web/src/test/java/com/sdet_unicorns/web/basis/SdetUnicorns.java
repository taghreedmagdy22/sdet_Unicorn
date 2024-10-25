package com.sdet_unicorns.web.basis;

import com.sdet_unicorns.web.pages.Home;
import com.sdet_unicorns.web.pages.Register;
import com.sdet_unicorns.web.driver.WebDriverSingleton;


public class SdetUnicorns {

    private final WebDriverSingleton webDriverSingleton = WebDriverSingleton.getDriverSingleton();
    public Home home;
    public Register register;

    public SdetUnicorns(){
        this.home = new Home();
    }

}
