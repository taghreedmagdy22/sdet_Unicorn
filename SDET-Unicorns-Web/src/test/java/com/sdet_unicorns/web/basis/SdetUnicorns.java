package com.sdet_unicorns.web.basis;

import com.sdet_unicorns.web.pages.Home;
import com.sdet_unicorns.web.pages.Login;
import com.sdet_unicorns.web.pages.Register;
import com.sdet_unicorns.web.driver.WebDriverSingleton;
import com.sdet_unicorns.web.pages.Shop;


public class SdetUnicorns {

    private final WebDriverSingleton webDriverSingleton = WebDriverSingleton.getDriverSingleton();
    public Home home;
    public Register register;
    public Shop shop;
    public Login login;

    public SdetUnicorns(){
        this.home = new Home();
    }

}
