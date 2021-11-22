package com.jfk.mavenproject;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
 
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class googleSearchDefinitions {
	String driverPath = "R:/Installers/chromedriver.exe";
	 
    WebDriver driver;
 
    googleSearch objSearch;
 
 
    @SuppressWarnings("deprecation")
	@Before
    public void setup() {
 
        // Initialize the webdriver and open the browser
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("www.google.com");
    }
 

    @Given("user open Google webpage")
    public void googlePage() {
 
        // Verify page title
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Google", pageTitle);

    }
 
    @And("search \"(.*?)\"")
    public void searchString(String strSearch) throws InterruptedException {
 
        // input search string
    	objSearch.setSearchString(strSearch);
 
        // click Google Search button
    	objSearch.clickSearchBtn();
    }
 
    @Then("verify Top Stories section is available")
    public void verifyTopStoriesSection() {
 
        // Verify Top stories section
    	WebElement topStories = driver.findElement(By.xpath("//div[@id='kp-wp-tab-overview']/div[1]"));
        Assert.assertTrue(topStories.isDisplayed());
    }
 
    @And("verify Health Information section is available")
    public void verifyHealthInformation() {
 
        // Verify Health Information section
    	WebElement healthInfo = driver.findElement(By.xpath("//div[@class='TzHB6b cLjAic'][3]"));
        Assert.assertTrue(healthInfo.isDisplayed());
    }
    
    @When("MOH link is clicked")
    public void clickMOHlink() throws InterruptedException {
 
        //click MOH homepage link
    	objSearch.clickMOHLink();
    }
    
    @Then("verify route to MOH page")
    public void MOHPage() {
 
        // Verify page title
        String pageTitle = driver.getTitle();
        Assert.assertEquals("Home | COVID-19 MALAYSIA", pageTitle);
    }
    
    @After
    public void close() {
 
        // Close the browser
        driver.close();
    }
}
