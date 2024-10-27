package com.sdet_unicorns.web.pages;

import org.openqa.selenium.By;

public class Product extends BasePage{

    private final By productDescription = By.xpath("//div[starts-with(@class,'product-details-content')]//h2");

    private final By productPrice = By.xpath("//div[@class = 'product-details-price']//span");

    private final By cartButton = By.xpath("//button[@class = 'icon-cart']");

    private final By emptyCartNotification = By.xpath("//div[starts-with(@class,'shopping-cart')]//p");

    private final By addToCartButton = By.xpath("//button[text() = 'Add To Cart']");

    private final By addedItemNotification = By.xpath("//div[text() = 'Added To Cart']");

    private final By cartItemsCount = By.xpath("//button[@class = 'icon-cart']//span");

    public String getProductDescription() {
        return findElementWhenPresent(productDescription).getText();
    }

    public String getProductPrice() {
        return findElementWhenPresent(productPrice).getText();
    }

    public void clickOnCartButton() {
        findElementWhenClickable(cartButton).click();
    }

    public boolean getEmptyCartNotificationPresence(){
        return elementDisplay(emptyCartNotification);
    }

    public void clickOnAddToCartButton() {
        findElementWhenClickable(addToCartButton).click();
    }

    public boolean getAddedItemNotificationPresence(){
        findElementWhenVisible(addedItemNotification);
        return true;
    }

    public String getCartItemsCount(){
        return findElementWhenPresent(cartItemsCount).getText();
    }


}
