package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ShippingPage extends BasePage {
    @FindBy(id = "BillingNewAddress_FirstName")//BillingNewAddress_FirstName
    WebElement firstname;

    @FindBy(id = "BillingNewAddress_LastName")
    WebElement lastname;

    @FindBy(id = "BillingNewAddress_Email")
    WebElement email;

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement country;

    @FindBy(id = "BillingNewAddress_City")
    WebElement city;

    @FindBy(id = "BillingNewAddress_Address1")//id="BillingNewAddress_Address1"
    WebElement addres_1;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postalCode;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement billingPhone;

    @FindBy(xpath = "//button[@class=\"button-1 new-address-next-step-button\"]")
    WebElement newAddressNextBtn;

    @FindBy(id = "shippingoption_1")
    WebElement shippingOpt_1;

    @FindBy(xpath = "//button[@class=\"button-1 shipping-method-next-step-button\"]")
    WebElement shippingNextBtn;
    @FindBy(xpath = "//button[@class=\"button-1 payment-method-next-step-button\"]")
    WebElement paymentNextBtn;
    @FindBy(xpath = "//button[@class=\"button-1 payment-info-next-step-button\"]")
    WebElement paymentInfoNextBtn;
    @FindBy(xpath = "//button[@class=\"button-1 confirm-order-next-step-button\"]")
    WebElement confirmNextBtn;

    @FindBy(id = "edit-billing-address-button")
    WebElement editBtn;

    @FindBy(id = "delete-billing-address-button")
    WebElement deleteBtn;


    public void billingAddress() {
        try {

                System.out.println("enter edit btn");
                deleteBtn.click();

        }catch (NoSuchElementException e)
        {
            System.err.println(e);
        }
        finally {
            System.out.println("Enter Bb");
            firstname.clear();
            firstname.sendKeys(ConfigReader.getConfigValue("firstname"));
            lastname.clear();
            lastname.sendKeys(ConfigReader.getConfigValue("lastname"));
            email.clear();
            email.sendKeys(ConfigReader.getConfigValue("email"));
            Select select = new Select(country);
            country.click();
            select.selectByIndex(3);
            city.sendKeys(ConfigReader.getConfigValue("city"));
            addres_1.sendKeys(ConfigReader.getConfigValue("address"));
            postalCode.sendKeys(ConfigReader.getConfigValue("postal"));
            billingPhone.sendKeys(ConfigReader.getConfigValue("phone"));
            newAddressNextBtn.click();
            System.out.println("Billing Done");
        }

    }

    public void shipping() {
        shippingOpt_1.click();
        shippingNextBtn.click();
        System.out.println("Shipping Done");
    }

    public void payment() {
        paymentNextBtn.click();
        System.out.println("Payment Done");
    }

    public void paymentInfo() {
        paymentInfoNextBtn.click();
        confirmNextBtn.click();
        System.out.println("PaymentInfo Done");
    }

    public void fillShippingDetails() {
        billingAddress();
        shipping();
        payment();
        paymentInfo();
        System.out.println("Order successfully Done");
    }

}
