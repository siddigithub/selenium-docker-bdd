package com.endtoendtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "pa_color")
    private WebElement colordrpDown;

    @FindBy(id = "pa_size")
    private WebElement sizedrpDown;

    @FindBy(css = ".single_add_to_cart_button.button.alt")
    private WebElement addtocartBtn;

    @FindBy(css = ".cart-name-and-total")
    private WebElement cartLink;

    @FindBy(css = ".checkout-button.button.alt.wc-forward")
    private WebElement proceedtoCheckoutBtn;

    public void proceedtoCheckout(){
        colordrpDown.sendKeys("White");
        sizedrpDown.sendKeys("Medium");
        addtocartBtn.click();
        cartLink.click();
        proceedtoCheckoutBtn.click();
    }
}
