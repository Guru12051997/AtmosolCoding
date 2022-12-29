package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class HomePage extends TestBase {
	// PageFactory

	@FindBy(xpath = "//h1[normalize-space()='Welcome to the Simple Travel Agency!']")
	@CacheLookup
	WebElement pagelogo;

	@FindBy(xpath = "//a[normalize-space()='destination of the week! The Beach!']")
	WebElement clickLink;

	@FindBy(xpath = "//select[@name='fromPort']")
	WebElement select1;
	
	@FindBy(xpath = "//select[@name='toPort']")
	WebElement select2;

	@FindBy(xpath = "//input[@value='Find Flights']")
	WebElement findflight;

	@FindBy(xpath = "//tbody/tr[3]/td[1]/input[1]")
	WebElement Lowpriceflight;

	@FindBy(xpath = "//em[normalize-space()='914.76']")
	WebElement totalCost;

	@FindBy(xpath = "//input[@value='Purchase Flight']")
	WebElement purchseflight;
	
	@FindBy(xpath = "//td[normalize-space()='Id']")
	WebElement idstore;

	// Initialise the page object
	
	public HomePage() {
		PageFactory.initElements(driver, this);// use also LoginPage.class
	}
	
	// Actions Methods

	public String ValidatePageTitle() {
		return driver.getTitle();

	}

	public boolean validatehomePage() {
		return pagelogo.isDisplayed();
	}

	public void Click() {
		clickLink.click();
	}

	public String GetUrl() {
		return driver.getCurrentUrl();

	}

	public void NAVIGATE() {

		driver.navigate().back();
	}

	public void DropdownValueCountry1(String Country1) {
		Select select = new Select(select1);
		select.selectByVisibleText(Country1);
	}

	public void DropdownValueCountry2(String Country2) {
		Select select1 = new Select(select2);
		select1.selectByVisibleText(Country2);
	}

	public void flightclick() {
		findflight.click();
		Lowpriceflight.click();
	}

	public boolean totalCostDisplay() {
		return totalCost.isDisplayed();
	}

	public void purchaseclick() {
		purchseflight.click();
	}

	public String idcapture(String id) {
		return idstore.getAttribute(id);
	}
}