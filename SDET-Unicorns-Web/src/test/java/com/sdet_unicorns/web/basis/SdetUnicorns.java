package com.sdet_unicorns.web.basis;

import com.sdet_unicorns.web.pages.*;
import com.sdet_unicorns.web.driver.WebDriverSingleton;


public class SdetUnicorns {

    private final WebDriverSingleton webDriverSingleton = WebDriverSingleton.getDriverSingleton();
    public Home home;
    public Register register;
    public Shop shop;
    public Login login;
    public Product product;

    public SdetUnicorns(){
        this.home = new Home();
    }

}
