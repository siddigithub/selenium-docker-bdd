package com.test.stepdefs;

import com.searchmodeule.pages.SearchPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Driver;

public class SearchSteps {

    private WebDriver driver;
    private WebDriverWait wait;
    private SearchPage searchPage;

    @Given("^I am on the website duck-duck-go$")
    public void iAmOnTheWebSite(){
        searchPage = new SearchPage(driver);
        searchPage.goToURL();
    }

    @And("^I enter the \"(.*)\" to search$")
    public void iEnterTheKeywordToSearch(String keyword){
        searchPage.doSearch(keyword);
    }

    @And("^I navigate to videos search$")
    public void iNavigateToVidoesSearch(){
        searchPage.gotoVideo();
    }

    @Then("I should get minimum (\\d+) search results")
    public void iShouldGetMinimumSearchResults(int min){
        int size = searchPage.getResult();
        Assert.assertTrue(size > min);
    }

    @Before
    public void setUpDriver() throws MalformedURLException {

        String host = "localhost";
        DesiredCapabilities desiredCapabilities;

        if (System.getProperty("Browser") != null && (System.getProperty("Browser")).equalsIgnoreCase("firefox")){
            desiredCapabilities = DesiredCapabilities.firefox();
        }else{
            desiredCapabilities = DesiredCapabilities.chrome();
        }

        if (System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String completeURL = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeURL), desiredCapabilities);
    }

    @After
    public void quitDriver(){
        this.driver.quit();
    }
}
