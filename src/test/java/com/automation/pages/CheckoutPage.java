package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutPage extends BasePage {

    @FindBy(xpath = "//a[text()='Computers ']")
    WebElement computersLink;

    @FindBy(xpath = "//a[@title=\"Show products in category Notebooks\"]")
    WebElement noteBookLink;

    @FindBy(xpath = "(//button[text()='Add to cart'])[1]")
    WebElement outsideAddToCart;

    @FindBy(id = "add-to-cart-button-4")
    WebElement insideAddToCart;

    @FindBy(xpath = "//a[@class=\"ico-cart\"]")
    WebElement addToCartLogo;

    @FindBy(id = "termsofservice")
    WebElement termsAndCondition;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    public void clickOnComputersLink() {

        computersLink.click();
    }

    public void clickOnNoteBookOpt() {
        noteBookLink.click();
    }

    public void addToCartProduct() {

        outsideAddToCart.click();
        insideAddToCart.click();
        driver.navigate().back();
    }

    public void clickOnAddToCartLogo() {
        addToCartLogo.click();
    }

    boolean flag=true;
    public void clickOnCheckOutBTN() {

        checkoutBtn.click();
        flag=false;
    }
    public void clickOnTerms() {
        termsAndCondition.click();

    }
    public boolean checkoutBtnDisplayed()
    {
        return flag;
    }

}
