package com.sdet_unicorns.web.pages;

import org.openqa.selenium.By;

public class Home extends BasePage{

    private final By userProfileDropDown = By.className("account-setting-active");

    private final By registerButton = By.xpath("//div[@class='account-dropdown active']//*[text()='Register']");

    private final By loginButton = By.xpath("//div[@class='account-dropdown active']//*[text()='Login']");


    public void clickOnUserProfileDropDown(){
        findElementWhenPresent(userProfileDropDown).click();
    }

    public Login clickOnLoginButton(){
        findElementWhenPresent(loginButton).click();
        return new Login();
    }

    public Register clickOnRegisterButton(){
        findElementWhenClickable(registerButton).click();
        return new Register();
    }
}
