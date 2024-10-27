package com.sdet_unicorns.web.pages;

import org.openqa.selenium.By;

import java.util.List;

public class Shop extends BasePage {

    private final By myAccountButton = By.xpath("//div[@class='account-dropdown']//*[text()='my account']");

    private final By logoutButton = By.xpath("//div[@class='account-dropdown']//*[text()='Logout']");

    private final By pageHeader = By.xpath("//span[contains(text(),'Shop')]");

    private final By productsTab = By.xpath("//div[@class = ' main-menu  ']//a[text()='Products']");

    private final By keyBoardButton = By.xpath("//div[@class='sidebar-widget-list-left']//button[text()='keyboard']");

    private final By applyButton = By.xpath("//button[contains(text(),'Apply')]");

    private final By filteredProducts = By.cssSelector(".product-content.text-center");


    public By getLogoutButton() {
        findElementWhenPresent(logoutButton);
        return logoutButton;
    }

    public By getMyAccountButton() {
        findElementWhenPresent(myAccountButton);
        return myAccountButton;
    }

    public void getPageHeaderText() {
        findElementWhenPresent(pageHeader);
    }

    public void clickProductsTab() {
        findElementWhenPresent(productsTab).click();
    }

    public void clickOnKeyboardButton() {
        findElementWhenPresent(keyBoardButton).click();
    }

    public void clickOnApplyButton() {
        findElementWhenPresent(applyButton).click();
    }


    public List<String> getFilteredProductsCategory() {
        List<String> productsCategory = new java.util.ArrayList<>(List.of());
        int size = findListOfElements(filteredProducts).size();
        for (int i = 0; i < size; i++) {
            productsCategory.add(findListOfElements(filteredProducts).get(i).getText());
        }
        return productsCategory;
    }

}



