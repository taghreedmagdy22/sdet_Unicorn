package com.sdet_unicorns.web.tests.shop;

import com.sdet_unicorns.web.tests.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class PurchaseStepDefs extends BaseTest {

    boolean loggedIn = false;
    float totalAmount = 0;


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

    @When("click on keyboard under categories list in products page")
    public void clickOnKeyboardUnderCategoriesListInProductsPage() {
            sdetUnicorns.shop.clickOnKeyboardCategoryButton();
    }

    @And("click on apply button in products page")
    public void clickOnApplyButtonInProductsPage() {
        sdetUnicorns.shop.clickOnApplyButton();
    }

    @Then("validate that filtered products are only the chosen category {string}")
    public void validateThatFilteredProductsAreOnlyTheChosenCategory(String itemType) {
        int size = sdetUnicorns.shop.getFilteredProductsCategory().size();
        String itemName = "";
        itemType = productDetails.getProperty(itemType);
        boolean keyboard = true;
        int i = 0;

        while ( i < size) {
            itemName = sdetUnicorns.shop.getFilteredProductsCategory().get(i);
            keyboard = itemName.contains(itemType);
            i++;
            if (keyboard == false )
                i = sdetUnicorns.shop.getFilteredProductsCategory().size();
        }
        Assert.assertEquals(keyboard, true);

    }

    @When("click on product item {string}")
    public void clickOnProductItem(String product) {
        sdetUnicorns.product = sdetUnicorns.shop.clickOnProductItem(productDetails.getProperty(product));
    }

    @Then("validate that product name {string} and price are valid")
    public void validateThatProductNameAndPriceAreValid(String productName) {
        Assert.assertEquals(sdetUnicorns.product.getProductDescription(),productDetails.getProperty(productName));
        Assert.assertEquals(sdetUnicorns.product.getProductPrice().contains("$"),true);
    }


    @Given("cart is empty")
    public void cartIsEmpty() throws InterruptedException {
        sdetUnicorns.product.clickOnCartButton();
        Assert.assertEquals(sdetUnicorns.product.getEmptyCartNotificationPresence(),true);
    }

    @When("click on Add to cart")
    public void clickOnAddToCart() {
        sdetUnicorns.product.clickOnAddToCartButton();
    }

    @Then("success message displayed for added item")
    public void successMessageDisplayedForAddedItem() {
        Assert.assertEquals(sdetUnicorns.product.getAddedItemNotificationPresence(),true);
    }


    @And("cart contains one {string} element")
    public void cartContainsOneElement(String count) {
        Assert.assertEquals(sdetUnicorns.product.getCartItemsCount(),count);
    }

    @When("click on laptop under categories list in products page")
    public void clickOnLaptopUnderCategoriesListInProductsPage() {
        sdetUnicorns.shop.clickOnLaptopCategoryButton();
    }

    @Then("two chosen products exist in cart")
    public void twoChosenProductsExistInCart() throws InterruptedException {
        sdetUnicorns.product.clickOnCartButton();
        Assert.assertEquals(sdetUnicorns.product.getCartItemATitle(),productDetails.getProperty("ProductAName"));
        Assert.assertEquals(sdetUnicorns.product.getCartItemBTitle(),productDetails.getProperty("ProductBName"));
    }

    @And("total amount calculated correctly")
    public void totalAmountCalculatedCorrectly() {
        float itemA = sdetUnicorns.product.getCartItemAPrice();
        float itemB = sdetUnicorns.product.getCartItemBPrice();
        totalAmount = itemB + itemA;

        Assert.assertEquals(sdetUnicorns.product.getTotalItemsAmount(),totalAmount);

    }

    @When("click on checkout button in cart page")
    public void clickOnCheckoutButtonInCartPage() {
        sdetUnicorns.cart = sdetUnicorns.product.clickOnViewCartButton();
        sdetUnicorns.checkout = sdetUnicorns.cart.clickOnProceedToCheckoutButton();
    }

    @And("select country {string} and select region {string} in cart page")
    public void selectCountryAndSelectRegionInCartPage(String country, String region) {
        sdetUnicorns.checkout.selectCountry(profileDetails.getProperty(country));
        sdetUnicorns.checkout.selectRegion(profileDetails.getProperty(region));
    }

    @And("enter first adress {string} and postal code {string} in cart page")
    public void enterFirstAdressAndPostalCodeInCartPage(String adress, String postalCode) {
        sdetUnicorns.checkout.enterAddressOneField(profileDetails.getProperty(adress));
        sdetUnicorns.checkout.enterPostalCodeField(profileDetails.getProperty(postalCode));
    }

    @And("enter phone number {string} in cart page")
    public void enterPhoneNumberInCartPage(String phone) {
        sdetUnicorns.checkout.enterPhoneField(profileDetails.getProperty(phone));
    }

    @And("mark cash on delivery checkbox in cart page")
    public void markCashOnDeliveryCheckboxInCartPage() {
        sdetUnicorns.checkout.clickOnCashOnDeliverCheckbox();
    }

    @And("click on confirm button in cart page")
    public void clickOnConfirmButtonInCartPage() {
        sdetUnicorns.order = sdetUnicorns.checkout.clickOnConfirmButton();
    }

    @And("click on order details")
    public void clickOnOrderDetails() {
        sdetUnicorns.order.clickOnOrderOne();
    }

    @Then("validate display of correct address {string} and amount {string}")
    public void validateDisplayOfCorrectFirstAddressAndAmount(String address, String total) {
        String retrievedAddress = sdetUnicorns.order.getAddressOneValue().substring(12);
        String retrievedAmount = sdetUnicorns.order.getTotalAmountValue().substring(9);
        Assert.assertEquals(retrievedAddress,profileDetails.getProperty(address));
        Assert.assertEquals(retrievedAmount.concat(".0"),Float.toString(sdetUnicorns.product.getTotalPayment()));
    }
}
