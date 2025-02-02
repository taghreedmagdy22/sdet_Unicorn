package com.sdet_unicorns.web.pages;

import com.sdet_unicorns.web.driver.WebDriverSingleton;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.interactions.Actions;



public abstract class BasePage {

    final int waitforElements = 150;
    public WebDriver driver = WebDriverSingleton.getWebDriver();
    public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitforElements));
    JavascriptExecutor jse = (JavascriptExecutor) driver;


    public void scrollOnPage() {
        jse.executeScript("window.scrollBy(0,-100)");
    }

    public void scrollDownPage() {
        jse.executeScript("window.scrollBy(0,500)");
    }

    public void moveToElementArea(By locator) {
        new Actions(driver).moveToElement(findElementWhenPresent(locator)).click().perform();
    }


    public WebElement findElementWhenPresent(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }

    public WebElement findElementWhenVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(locator)));
        return driver.findElement(locator);
    }

    public WebElement findElementWhenClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        return driver.findElement(locator);
    }

    public boolean elementDisplay(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean elementExist (By locator){
        try {
            return driver.findElements(locator).size() != 0;
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> findListOfElements(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(locator)));
        return driver.findElements(locator);
    }

}