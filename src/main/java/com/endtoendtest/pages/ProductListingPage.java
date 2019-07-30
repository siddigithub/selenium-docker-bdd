package com.endtoendtest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductListingPage {

    private WebDriver driver;
    public ProductListingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".owl-item.active")
    private List<WebElement> itemList;

    public void selectFirstItem(){
        itemList.get(0).click();
    }
}
