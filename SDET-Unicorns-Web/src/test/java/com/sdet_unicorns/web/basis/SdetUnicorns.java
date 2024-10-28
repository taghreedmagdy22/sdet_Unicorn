package com.sdet_unicorns.web.basis;

import com.sdet_unicorns.web.pages.*;
import com.sdet_unicorns.web.driver.WebDriverSingleton;
import org.checkerframework.checker.units.qual.C;


public class SdetUnicorns {

    private final WebDriverSingleton webDriverSingleton = WebDriverSingleton.getDriverSingleton();
    public Home home;
    public Register register;
    public Shop shop;
    public Login login;
    public Product product;
    public Cart cart;
    public Order order;
    public Checkout checkout;


    public SdetUnicorns(){
        this.home = new Home();
    }

}
