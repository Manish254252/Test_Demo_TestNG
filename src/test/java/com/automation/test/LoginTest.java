package com.automation.test;

import com.automation.utils.ConfigReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    void doLogin() {
    loginPage.openWebsite();
    loginPage.enterEmail(ConfigReader.getConfigValue("email"));
    loginPage.enterPassword(ConfigReader.getConfigValue("password"));
    loginPage.clickSubmit();
    }
}
