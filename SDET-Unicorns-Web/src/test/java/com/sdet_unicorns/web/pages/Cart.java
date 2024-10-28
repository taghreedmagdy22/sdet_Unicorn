package com.sdet_unicorns.web.pages;

import org.openqa.selenium.By;

public class Cart extends BasePage{

   private final By proceedToCheckoutButton = By.xpath("//a[text() = 'Proceed to Checkout']");

    public Checkout clickOnProceedToCheckoutButton() {
        scrollDownPage();
        moveToElementArea(proceedToCheckoutButton);
        findElementWhenVisible(proceedToCheckoutButton).click();
        return new Checkout();
    }


}
