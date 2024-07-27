package com.automation.test;

import com.automation.utils.AllureReportManager;
import com.automation.utils.ConfigReader;
import com.automation.utils.ExtentReportManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    void doLogin() {
    loginPage.openWebsite();
        AllureReportManager.attachScreenShot();

    loginPage.enterEmail(ConfigReader.getConfigValue("email"));
    loginPage.enterPassword(ConfigReader.getConfigValue("password"));
    loginPage.clickSubmit();
    Assert.assertFalse(true);
   ;
    }
}
