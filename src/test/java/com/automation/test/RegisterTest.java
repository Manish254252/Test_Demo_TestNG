package com.automation.test;

import com.automation.pages.RegisterPage;
import com.automation.utils.AllureReportManager;
import com.automation.utils.ConfigReader;
import org.testng.annotations.Test;

public class RegisterTest extends BaseTest {
//    RegisterPage registerPage = new RegisterPage();
    @Test
    void register()
    {
        registerPage.openWebsite();
        AllureReportManager.attachScreenShot();
        registerPage.selectMaleGender();
        AllureReportManager.attachScreenShot();
        registerPage.enterFirstName(ConfigReader.getConfigValue("firstname"));
        registerPage.enterLastName(ConfigReader.getConfigValue("lastname"));
        registerPage.selectDOB(ConfigReader.getConfigValue("DOB"));
        registerPage.enterEmail(ConfigReader.getConfigValue("email"));
        registerPage.enterPassword(ConfigReader.getConfigValue("password"));
        registerPage.enterConfirmPassword(ConfigReader.getConfigValue("password"));
        registerPage.clickRegisterBtn();
    }
}
