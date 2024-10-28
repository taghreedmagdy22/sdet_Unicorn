package com.sdet_unicorns.web.pages;

import org.openqa.selenium.By;

public class Order extends BasePage{

    private final By orderOne = By.xpath("//h3[@class='panel-title']//span[text() = '1']");

    private final By addressOneValue = By.xpath("//h4[contains(text(),'Address 1 :')]");

    private final By totalAmountValue = By.xpath("//h4[contains(text(),'Total')]");

    public void clickOnOrderOne( ) {
        findElementWhenPresent(orderOne).click();

    }

    public String getAddressOneValue(){
       return findElementWhenVisible(addressOneValue).getText();
    }

    public String getTotalAmountValue(){
        return findElementWhenVisible(totalAmountValue).getText();
    }

}
