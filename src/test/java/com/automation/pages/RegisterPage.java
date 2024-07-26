package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class RegisterPage extends BasePage {

    @FindBy(id = "gender-male")
    WebElement gender;

    @FindBy(id = "FirstName")
    WebElement firstname;

    @FindBy(id = "LastName")
    WebElement lastname;

    @FindBy(name = "DateOfBirthDay")
    WebElement selectorOfDay;

    @FindBy(name = "DateOfBirthMonth")
    WebElement selectorOfMonth;

    @FindBy(name = "DateOfBirthYear")
    WebElement selectorOfYear;

    @FindBy(id = "Email")
    WebElement email;

    @FindBy(id = "Password")
    WebElement password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerBtn;


    public void openWebsite() {
        driver.get("https://demo.nopcommerce.com/register");
    }

    public void selectMaleGender() {
        gender.click();
    }

    public void enterFirstName(String data) {
        firstname.sendKeys(data);
    }

    public void enterLastName(String data) {
        lastname.sendKeys(data);
    }

    public void selectDOB(String date) {
        String[] values = date.split("-");
        Select selectDay = new Select(selectorOfDay);
        selectorOfDay.click();
        selectDay.selectByValue(values[0]);
        Select selectMonth = new Select(selectorOfMonth);
        selectorOfMonth.click();
        selectMonth.selectByIndex(Integer.parseInt(values[1]));
        Select selectYear = new Select(selectorOfYear);
        selectorOfYear.click();
        selectYear.selectByValue(values[2]);
    }

    public void enterEmail(String data) {
        email.sendKeys(data);
    }

    public void enterPassword(String data) {
        password.sendKeys(data);
    }

    public void enterConfirmPassword(String data) {
        confirmPassword.sendKeys(data);
    }

    public void clickRegisterBtn() {
        registerBtn.click();
    }

    public void register() {
        openWebsite();
        selectMaleGender();
        enterFirstName(ConfigReader.getConfigValue("firstname"));
        enterLastName(ConfigReader.getConfigValue("lastname"));
        selectDOB(ConfigReader.getConfigValue("DOB"));
        enterEmail(ConfigReader.getConfigValue("email"));
        enterPassword(ConfigReader.getConfigValue("password"));
        enterConfirmPassword(ConfigReader.getConfigValue("password"));
        clickRegisterBtn();
    }
}
