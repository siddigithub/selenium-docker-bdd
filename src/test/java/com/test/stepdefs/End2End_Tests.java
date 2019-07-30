package com.test.stepdefs;

import com.endtoendtest.pages.*;
import com.manager.FileReaderManager;
import com.manager.PageObjectManager;
import com.utilities.ConfigFileReader;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class End2End_Tests {

    private WebDriver driver;
    private HomePage homePage;
    private ProductListingPage productListingPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private ConfirmationPage confirmationPage;

    PageObjectManager pageObjectManager;

    @Given("^user is on the Home Page$")
    public void user_is_on_the_Home_Page() throws Throwable {

        String driverpath = FileReaderManager.getInstance().getConfigFileReader().loadProperties("config.properties").getProperty("driverpath");
        String URL = FileReaderManager.getInstance().getConfigFileReader().loadProperties("config.properties").getProperty("URL");
        // Write code here that turns the phrase above into concrete actions
//        Properties properties = configFileReader.loadProperties("config.properties");
        System.setProperty("webdriver.chrome.driver", driverpath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get(URL);
    }

    @When("^he search for \"([^\"]*)\"$")
    public void he_search_for(String item) throws Throwable {
        pageObjectManager = new PageObjectManager(driver);
        homePage = pageObjectManager.getHomePage();
        homePage.perform_search("DRESS");
    }

    @When("^choose to buy the first item$")
    public void choose_to_buy_the_first_item() throws Throwable {
        productListingPage = pageObjectManager.getproductListingPage();
        productListingPage.selectFirstItem();
    }

    @When("^moves to checkout from mini cart$")
    public void moves_to_checkout_from_mini_cart() throws Throwable {
        cartPage = pageObjectManager.getCartPage();
        cartPage.proceedtoCheckout();
    }

    @When("^enter personal details on checkout page$")
    public void enter_personal_details_on_checkout_page() throws Throwable {
        checkoutPage = pageObjectManager.getCheckoutPage();
        checkoutPage.fillPersonalDetails();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-500);");

        Thread.sleep(10000);

        checkoutPage.clickOnPlaceOrder();
    }

    @When("^select the same delivery address$")
    public void select_the_same_delivery_address() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^select the payment method as \"([^\"]*)\" payment$")
    public void select_the_payment_method_as_payment(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @When("^place the order$")
    public void place_the_order() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I am on the website duck-duck-go$")
    public void i_am_on_the_website_duck_duck_go() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I enter the \"([^\"]*)\" to search$")
    public void i_enter_the_to_search(String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^I navigate to videos search$")
    public void i_navigate_to_videos_search() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should get minimum (\\d+) search results$")
    public void i_should_get_minimum_search_results(int arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
    }

    @Then("^order is confirmed$")
    public void theOrderIsConfirmed() {
        confirmationPage = pageObjectManager.getConfirmationPage();
        Assert.assertTrue(confirmationPage.getConfirmationText().contains("Thank you. Your order has been received."));
        driver.quit();
    }
}
