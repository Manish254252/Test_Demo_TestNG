package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{
    @Test
    void checkOut()
    {
        registerPage.register();
        loginPage.doLogin();
        checkoutPage.clickOnComputersLink();
        checkoutPage.clickOnNoteBookOpt();
        checkoutPage.addToCartProduct();
        checkoutPage.clickOnAddToCartLogo();
        checkoutPage.clickOnTerms();
        checkoutPage.clickOnCheckOutBTN();
        Assert.assertFalse(checkoutPage.checkoutBtnDisplayed());
        shippingPage.fillShippingDetails();
        actions.pause(4000).build().perform();

    }
}
