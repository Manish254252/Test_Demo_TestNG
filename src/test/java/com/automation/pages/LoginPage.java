package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(xpath = "//button[@class=\"button-1 login-button\"]")
    WebElement submitBtn;

    public void openWebsite() {
        driver.get("https://demo.nopcommerce.com/login");
    }

    public void enterEmail(String data) {
        email.sendKeys(data);
    }

    public void enterPassword(String data) {
        password.sendKeys(data);
    }

    public void clickSubmit() {
        submitBtn.click();
    }

    public void doLogin() {
        openWebsite();
        enterEmail(ConfigReader.getConfigValue("email"));
        enterPassword(ConfigReader.getConfigValue("password"));
        clickSubmit();
    }
}
