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

    private final By cartItemATitle = By.xpath("//li[@class='single-shopping-cart'][1]//h4//a");

    private final By cartItemBTitle = By.xpath("//li[@class='single-shopping-cart'][2]//h4//a");

    private final By cartItemAPrice = By.xpath("//li[@class='single-shopping-cart'][1]//span");

    private final By cartItemBPrice = By.xpath("//li[@class='single-shopping-cart'][2]//span");

    private final By totalItemsAmount = By.xpath("//span[@class='shop-total']");

    private final By viewCartButton = By.xpath("//a[@href = '/cart']");

    private float totalPayment = 0;


    public String getProductDescription() {
        return findElementWhenPresent(productDescription).getText();
    }

    public String getProductPrice() {
        return findElementWhenPresent(productPrice).getText();
    }

    public void clickOnCartButton() throws InterruptedException {
        Thread.sleep(500);
        findElementWhenVisible(cartButton);
        elementDisplay(cartButton);
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

    public String getCartItemATitle(){
        return findElementWhenPresent(cartItemATitle).getText();
    }

    public String getCartItemBTitle(){
        return findElementWhenPresent(cartItemBTitle).getText();
    }

    public float getCartItemAPrice(){
        float price = 0;
        String priceValue = findElementWhenPresent(cartItemAPrice).getText();
        price = Float.parseFloat(priceValue);
        return price;
    }

    public float getCartItemBPrice(){
        float price = 0;
        String priceValue = findElementWhenPresent(cartItemBPrice).getText();
        price = Float.parseFloat(priceValue);
        return price;
    }

    public float getTotalItemsAmount(){
        String priceValue = findElementWhenPresent(totalItemsAmount).getText().substring(1);
        totalPayment = Float.parseFloat(priceValue);
        return totalPayment;
    }

    public Cart clickOnViewCartButton() {
        findElementWhenPresent(viewCartButton).click();
        return new Cart();
    }

    public float getTotalPayment() {
        return totalPayment;
    }
}