package com.endtoendtest.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    private WebDriver driver;

    public CheckoutPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "billing_first_name")
    private WebElement billingfirstnametxt;

    @FindBy(name = "billing_last_name")
    private WebElement billinglastnametxt;

    @FindBy(name = "billing_address_1")
    private WebElement billingaddresstxt;

    @FindBy(name = "billing_city")
    private WebElement billingcitytxt;

    @FindBy(id = "billing_postcode")
    private WebElement billingpostcodetxt;

    @FindBy(id = "billing_phone")
    private WebElement billingphonetxt;

    @FindBy(id = "billing_email")
    private WebElement billingemailtxt;

    @FindBy(id = "terms")
    private WebElement billingtermsCheck;

    @FindBy(name = "woocommerce_checkout_place_order")
    private WebElement placeorderBtn;


    public void fillPersonalDetails() throws InterruptedException {

        billingfirstnametxt.sendKeys("TEST");
        billinglastnametxt.sendKeys("TEST");
        billingaddresstxt.sendKeys("15 TEST");
        billingcitytxt.sendKeys("TEST");
        billingtermsCheck.click();
        billingpostcodetxt.sendKeys("RG7 8NN");
        billingphonetxt.sendKeys("07899");
        billingemailtxt.sendKeys("TEST@TEST.com");

//        Thread.sleep(20000);

//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)this.driver;
//        ((JavascriptExecutor)this.driver).executeScript("window.scrollBy(0, -500);");
//        ((JavascriptExecutor) this.driver).executeScript("window.scrollIntoView();", billingtermsCheck);

//        javascriptExecutor.executeScript("arguments[0].click();", placeorderBtn);



    }

    public void clickOnPlaceOrder(){
        placeorderBtn.click();
    }

//        driver.findElement(By.name("billing_first_name")).sendKeys("TEST");
//        driver.findElement(By.name("billing_last_name")).sendKeys("TEST");
//        driver.findElement(By.name("billing_address_1")).sendKeys("15 TEST");
//        driver.findElement(By.name("billing_city")).sendKeys("TEST");
//        driver.findElement(By.id("billing_postcode")).sendKeys("RG7 8NN");
//        driver.findElement(By.id("billing_phone")).sendKeys("07999999");
//        driver.findElement(By.id("billing_email")).sendKeys("test@test.com");
//        Thread.sleep(20000);
//
//        driver.findElement(By.id("terms")).click();
//        driver.findElement(By.name("woocommerce_checkout_place_order")).click();
//        driver.quit();
}
