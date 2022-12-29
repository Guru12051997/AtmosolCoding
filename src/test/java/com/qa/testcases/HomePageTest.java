package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homePage;

	public HomePageTest() {
		super();

	}

	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}

	@Test(priority = 1)
	public void loginPageTitleTest() throws InterruptedException {
		// Validate the title

		String title = homePage.ValidatePageTitle();
		System.out.println("------------" + title + "---------------");
		Assert.assertEquals(title, "BlazeDemo");

		// Check if the title is displayed as ` Welcome to the Simple Travel Agency!`.
		// This is the Home Page of application

		System.out.println(homePage.validatehomePage());

		// Click on ` destination of the week! The Beach!` hyperlink and see if a new
		// tab opens in your browser & the url has string `vacation`. Navigate back to
		// home page tab.
		homePage.Click();

		String title1 = homePage.ValidatePageTitle();
		System.out.println("------------" + title1 + "---------------");
		Assert.assertEquals(title1, "BlazeDemo - vacation");

		System.out.println(homePage.GetUrl());

		homePage.NAVIGATE();
		Thread.sleep(3000);

		homePage.DropdownValueCountry1("Mexico City");
		homePage.DropdownValueCountry2("London");
		homePage.flightclick();

		System.out.println(homePage.totalCostDisplay());// display true if totalcost is present

		homePage.purchaseclick();

		System.out.println(homePage.idcapture("id"));

	}

	@AfterMethod
	public void tearDown() {
	//	driver.quit();
	}
}
