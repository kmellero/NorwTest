package com.norw.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.norw.qa.base.TestBase;
import com.norw.qa.pages.ChooseFlightDestDatesPage;
import com.norw.qa.pages.HomePage;
import com.norw.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ChooseFlightDestDatesPage chooseFligthsPage;
	
	public LoginPageTest()	{

		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		chooseFligthsPage = new ChooseFlightDestDatesPage();
		homePage = new HomePage();
		loginPage = homePage.clickInloggning();
	}

	@Test
	public void checkUsr() {

		Assert.assertTrue(loginPage.checkUsername());
	}
	
	@Test
	public void checkPass() {	
		
		Assert.assertTrue(loginPage.checkPassword());
	}	

	@Test
	public void checkLogBtn() {
		
		Assert.assertTrue(loginPage.loggaInDisp());
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
