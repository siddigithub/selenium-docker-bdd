package com.searchmodeule.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SearchPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "q")
    private WebElement txtSearh;

    @FindBy(id = "search_button_homepage")
    private WebElement btnSearch;

    @FindBy(linkText = "Videos")
    private WebElement videoLink;

    @FindBy(className = "js-lazyload")
    private List<WebElement> allVideos;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 30);
        PageFactory.initElements(driver, this);
    }

    public void goToURL(){
        this.driver.get("https://duckduckgo.com/");
    }

    public void doSearch(String keyword){
        this.wait.until(ExpectedConditions.visibilityOf(this.txtSearh));
        this.txtSearh.sendKeys(keyword);
        this.btnSearch.click();
    }

    public void gotoVideo(){
        this.wait.until(ExpectedConditions.elementToBeClickable(this.videoLink));
        this.videoLink.click();
    }

    public int getResult(){
        By by = By.className("js-lazyload");
        this.wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(by, 0));
        return this.allVideos.size();
    }
}
