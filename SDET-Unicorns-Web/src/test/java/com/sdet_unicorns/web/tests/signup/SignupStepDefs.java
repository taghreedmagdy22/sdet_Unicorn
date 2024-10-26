package com.sdet_unicorns.web.tests.signup;

import com.sdet_unicorns.web.pages.Shop;
import com.sdet_unicorns.web.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class SignupStepDefs extends BaseTest {

    boolean registered = false;

    @When("open SDETUnicorns and click on user profile button in home page")
    public static void openSdetUnicornsAndClickOnUSerProfileButtonInHomePage() {
        sdetUnicorns.home.clickOnUserProfileDropDown();
    }

    @When("select register option from user profile menu in home page")
    public void selectRegisterOptionFromUserProfileMenuInHomePage() {
        sdetUnicorns.register = sdetUnicorns.home.clickOnRegisterButton();
    }

    @And("enter username {string} in registration page")
    public void enterUsernameInRegistrationPage(String username) {
        sdetUnicorns.register.enterUsername(profileDetails.getProperty(username));
    }

    @And("enter email {string} in registration page")
    public void enterEmailInRegistrationPage(String email) {
        sdetUnicorns.register.enterEmail(profileDetails.getProperty(email));
    }

    @And("enter password {string} in registration page")
    public void enterPasswordInRegistrationPage(String password) {
        sdetUnicorns.register.enterPassword(profileDetails.getProperty(password));
    }

    @And("select gender {string} in registration page")
    public void selectGenderInRegistrationPage(String gender) {
        sdetUnicorns.register.enterGender(profileDetails.getProperty(gender));
    }

    @And("click on register button in registration page")
    public void clickOnRegisterButtonInRegistrationPage() {
        sdetUnicorns.shop = sdetUnicorns.register.clickOnRegisterButton();
    }

    @Then("validate that user profile contains button logout")
    public void validateThatUserProfileContainsButtonLogout() {
        registered = sdetUnicorns.shop.elementExist(sdetUnicorns.shop.getLogoutButton());
        Assert.assertEquals(registered,true);
    }
}
