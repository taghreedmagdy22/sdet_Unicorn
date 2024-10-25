package com.sdet_unicorns.web.pages;

import org.openqa.selenium.By;

public class Shop extends BasePage{

    private final By logoutButton = By.xpath("//div[@class='account-dropdown']//*[text()='Logout']");

    public By getLogoutButton(){
        findElementWhenPresent(logoutButton);
        return logoutButton;
    }

}
