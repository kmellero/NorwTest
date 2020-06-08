package com.norw.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.norw.qa.base.TestBase;
import com.norw.qa.pages.BookingPage;
import com.norw.qa.pages.ChooseFlightDestDatesPage;
import com.norw.qa.pages.HomePage;
import com.norw.qa.pages.LoginPage;

public class ChooseFlightDestDatesPageTest extends TestBase {

	LoginPage loginPage;
	HomePage homePage;
	ChooseFlightDestDatesPage chooseFligthsPage;
	BookingPage bookingPage;

	
	public ChooseFlightDestDatesPageTest() {
		super();
	}
	
 
	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		chooseFligthsPage = new ChooseFlightDestDatesPage();
		loginPage = homePage.clickInloggning();

		Thread.sleep(3000);
		System.out.println("config: user-->"+prop.getProperty("user")+" password-->"+prop.getProperty("password"));
		chooseFligthsPage = loginPage.loging(prop.getProperty("user"), prop.getProperty("password"));

	}
	
	@Test
	public void validateUsrInCaps() {
		Assert.assertTrue(chooseFligthsPage.validateUsrCaps());
	}

	@Test
	public void validateBokaFlyg(){
		Assert.assertTrue(chooseFligthsPage.validateSokBokning());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
