package com.norw.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.norw.qa.base.TestBase;
import com.norw.qa.pages.HomePage;
import com.norw.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	
	public HomePageTest() {   
		//constructor
		//1. it must call TestBase constructor first via super()
		//2. this gets all properties from TestBase constructor
		//3. only then it can call TestBase.initialization() method
		super();
	}
	
	
	@BeforeMethod
	public void setUp() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test  // (priority=1) removed because only first test is run from a class in a suite of tests 
	public void homePageTitleTest() {
		String homePageTitle = homePage.validateHomePage();
		Assert.assertEquals(homePageTitle, "Billiga flyg och goda erbjudanden på flygresor | Norwegian");
	}
	
	@Test //(priority=2)
	public void checkLogoTest() {
		boolean flag = homePage.checkLogo();
		Assert.assertTrue(flag);
	}
	
	@Test //(priority=3)
	public void  loginLnkTest() {  
		homePage.clickInloggning();
	}
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	
	

}
