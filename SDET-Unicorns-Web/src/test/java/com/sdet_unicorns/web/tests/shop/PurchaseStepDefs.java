package com.sdet_unicorns.web.tests.shop;

import com.sdet_unicorns.web.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
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
        loggedIn = sdetUnicorns.shop.elementExist(sdetUnicorns.shop.getMyAccountButton());
        Assert.assertEquals(loggedIn,true);
    }

    @Given("user is on products page")
    public void userIsOnProductsPage() {
        sdetUnicorns.shop.clickProductsTab();
    }

    @When("click on keyboards under categories list in products page")
    public void clickOnKeyboardsUnderCategoriesListInProductsPage() {
        sdetUnicorns.shop.clickOnKeyboardButton();
    }

    @And("click on apply button in products page")
    public void clickOnApplyButtonInProductsPage() {
        sdetUnicorns.shop.clickOnApplyButton();
    }

    @Then("validate that filtered products are only the chosen category {string}")
    public void validateThatFilteredProductsAreOnlyTheChosenCategory(String category) {
        Assert.assertEquals(sdetUnicorns.shop.checkFilteredProducts(category),true);
    }

}
