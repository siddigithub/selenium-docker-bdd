package com.endtoendtest.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "noo-search")
    private WebElement searchLink;

    @FindBy(name = "s")
    private WebElement txtSearch;

    public void navigateToDemoSite(){
        driver.get("http://www.shop.demoqa.com");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public void perform_search(String item){
        searchLink.click();
        txtSearch.sendKeys(item);
        txtSearch.sendKeys(Keys.ENTER);
    }
}
