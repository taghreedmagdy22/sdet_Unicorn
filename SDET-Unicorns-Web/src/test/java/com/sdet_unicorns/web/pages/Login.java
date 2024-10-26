package com.sdet_unicorns.web.pages;

import org.openqa.selenium.By;

public class Login extends BasePage{

    private final By emailField = By.id("email");

    private final By passwordField = By.id("password");

    private final By loginButton = By.xpath("//button[contains(text(),'Login')]");


    public void enterEmail(String email) {
        findElementWhenPresent(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        findElementWhenPresent(passwordField).sendKeys(password);
    }

    public Shop clickOnLoginButton(){
        findElementWhenPresent(loginButton).click();
        return new Shop();
    }


}
