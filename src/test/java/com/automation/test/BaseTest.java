package com.automation.test;


import com.automation.pages.CheckoutPage;
import com.automation.pages.LoginPage;
import com.automation.pages.RegisterPage;
import com.automation.pages.ShippingPage;
import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;
import java.util.Random;


public class BaseTest {

    Actions actions;
    LoginPage loginPage;
    RegisterPage registerPage;
    CheckoutPage checkoutPage;
    ShippingPage shippingPage;


    @BeforeMethod
    public void setUp(ITestContext context) {


        ConfigReader.initConfig();
        DriverManager.createDriver();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        checkoutPage = new CheckoutPage();
        shippingPage = new ShippingPage();
        actions = new Actions(DriverManager.getDriver());

    }

    @AfterMethod
    public void cleanUp() {
        DriverManager.getDriver().quit();

    }

    public static void takeScreenShot() {
        System.out.println("Entre Screenshot");
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File file = ts.getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        int a = random.nextInt(1000);
        String filePath = "src/test/resources" + "/screenshot" + a + ".png";
        try {
            FileUtils.copyFile(file, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.getProperty("user.dir");
    }
}
