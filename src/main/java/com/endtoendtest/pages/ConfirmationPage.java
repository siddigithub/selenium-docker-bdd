package com.endtoendtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {

    private WebDriver driver;
    public ConfirmationPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".woocommerce-thankyou-order-received")
    private WebElement orderReceivedText;

    public String getConfirmationText(){
        return orderReceivedText.getText();
    }
}
