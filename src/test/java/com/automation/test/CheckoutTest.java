package com.automation.test;

import com.automation.utils.AllureReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest{
    @Test
    void checkOut()
    {
        registerPage.register();
        AllureReportManager.attachScreenShot();
        loginPage.doLogin();
        checkoutPage.clickOnComputersLink();
        AllureReportManager.attachScreenShot();
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
