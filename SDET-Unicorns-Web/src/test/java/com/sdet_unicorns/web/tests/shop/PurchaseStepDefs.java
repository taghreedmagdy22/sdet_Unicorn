package com.sdet_unicorns.web.tests.shop;

import com.sdet_unicorns.web.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PurchaseStepDefs extends BaseTest {

    boolean loggedIn = false;

    @When("select login option from user profile menu in home page")
    public void selectLoginOptionFromUserProfileMenuInHomePage() {
        sdetUnicorns.login = sdetUnicorns.home.clickOnLoginButton();
    }


    @And("enter email {string} and password {string} in login page")
    public void enterEmailAndPasswordInLoginPage(String email, String password) {
        sdetUnicorns.login.enterEmail(profileDetails.getProperty(email));
        sdetUnicorns.login.enterPassword(profileDetails.getProperty(password));
    }

    @And("click on login button in login page")
    public void clickOnLoginButtonInLoginPage() {
        sdetUnicorns.shop = sdetUnicorns.login.clickOnLoginButton();
    }


    @Then("validate that user profile contains button my account")
    public void validateThatUserProfileContainsButtonMyAccount() {
        loggedIn = sdetUnicorns.shop.elementExist(sdetUnicorns.shop.getMyAccountButtonButton());
        Assert.assertEquals(loggedIn,true);
    }
}
