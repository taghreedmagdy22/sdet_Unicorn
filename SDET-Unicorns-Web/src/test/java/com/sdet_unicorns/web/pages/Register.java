package com.sdet_unicorns.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Register extends BasePage{

    private final By usernameField = By.id("username");

    private final By emailField = By.id("email");

    private final By passwordField = By.id("password");

    private final By genderField = By.id("gender");

    private final By registerButton = By.xpath("//button[contains(text(),'Register')]");

    private Select genderDropDown;

    public void enterUsername(String username) {
        findElementWhenPresent(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        findElementWhenPresent(passwordField).sendKeys(password);
    }

    public void enterEmail(String email) {
        findElementWhenPresent(emailField).sendKeys(email);
    }

    public void enterGender(String gender) {
        genderDropDown = new Select(findElementWhenPresent(genderField));
        genderDropDown.selectByVisibleText(gender);
    }

    public Shop clickOnRegisterButton() {
        findElementWhenVisible(registerButton).click();
        return new Shop();
    }



}
