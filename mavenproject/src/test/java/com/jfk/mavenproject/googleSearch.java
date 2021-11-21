package com.jfk.mavenproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class googleSearch {
	WebDriver driver;
	   
    @FindBy(name = "q")
    WebElement searchInputField;
 
    @FindBy(xpath = "//div[@class='FPdoLc lJ9FBc']//input[1]")
    WebElement btnSearch;
    
    @FindBy(xpath = "//a[contains(., 'COVID-19 MALAYSIA: Home')]")
    WebElement lnkMOH;
 
    public googleSearch(WebDriver driver) {
 
        this.driver = driver;
 
        // This initElements method will create all WebElements
        PageFactory.initElements(driver, this);
    }
 
    // Set search input field
    public void setSearchString(String sInputField) {
    	searchInputField.sendKeys(sInputField);
    }
 
    // Click Google Search button
    public void clickSearchBtn() throws InterruptedException {
    	btnSearch.click();
    	
    }
 
    // Click MOH link
    public void clickMOHLink() throws InterruptedException {
    	lnkMOH.click();

    }
}
