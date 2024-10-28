package com.sdet_unicorns.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

public class Checkout extends BasePage {

    private final By countryField = By.xpath("//select[@name = 'rcrs-country']");
    private Select countryDropDown;
    private final By regionField = By.xpath("//select[@name = 'rcrs-region']");
    private Select regionDropDown;
    private final By addressOneField = By.xpath("//input[@name = 'address1']");
    private final By postalCodeField = By.xpath("//input[@name = 'postalcode']");
    private final By PhoneField = By.xpath("//input[@name = 'contact']");
    private final By cashOnDeliveryCheckbox = By.xpath("//div[@class = 'tax-select']//label");
    private final By confirmButton = By.xpath("//button[@class = 'btn-hover']");



    public void selectCountry(String country) {
        countryDropDown = new Select(findElementWhenPresent(countryField));
        countryDropDown.selectByVisibleText(country);
    }

    public void selectRegion(String region) {
        regionDropDown = new Select(findElementWhenPresent(regionField));
        regionDropDown.selectByVisibleText(region);
    }

    public void enterAddressOneField(String address) {
        findElementWhenPresent(addressOneField).sendKeys(address);
    }

    public void enterPostalCodeField(String postalCode) {
        findElementWhenPresent(postalCodeField).sendKeys(postalCode);
    }

    public void enterPhoneField(String phone) {
        findElementWhenPresent(PhoneField).sendKeys(phone);
    }

    public void clickOnCashOnDeliverCheckbox() {
        findElementWhenPresent(cashOnDeliveryCheckbox).click();
    }

    public Order clickOnConfirmButton(){
        findElementWhenVisible(confirmButton).click();
        return new Order();
    }
}
