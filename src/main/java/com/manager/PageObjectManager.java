package com.manager;

import com.endtoendtest.pages.*;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    private WebDriver driver;

    private HomePage homePage;
    private ProductListingPage productListingPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;

    public PageObjectManager(WebDriver driver){
        this.driver = driver;
    }

    public HomePage getHomePage(){
        return (homePage == null) ? homePage = new HomePage(driver) : homePage;
    }

    public ProductListingPage getproductListingPage(){
        return (productListingPage == null) ? productListingPage = new ProductListingPage(driver) : productListingPage;
    }

    public CartPage getCartPage(){
        return (cartPage == null) ? cartPage = new CartPage(driver) : cartPage;
    }

    public CheckoutPage getCheckoutPage(){
        return (checkoutPage == null) ? checkoutPage = new CheckoutPage(driver) : checkoutPage;
    }

    public ConfirmationPage getConfirmationPage(){
        return (confirmationPage == null) ? confirmationPage = new ConfirmationPage(driver) : confirmationPage;
    }
}
