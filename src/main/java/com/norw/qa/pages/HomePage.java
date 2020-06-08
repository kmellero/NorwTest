package com.norw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.norw.qa.base.TestBase;

public class HomePage extends TestBase {
	
	//Page Factory or Object Repository
	
	@FindBy(xpath="//a[@class='page-header__profile__trigger']")
	WebElement inloggning;
	
	@FindBy(xpath="//img[contains(@class,'page-header__logo--md')]")   //   "//img[@class='page-header__logo']")
	WebElement logoNorw;
	
	//initializing Page Objects
	public HomePage(){
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateHomePage() {
		return driver.getTitle();
	}
	public boolean checkLogo() {
		return logoNorw.isDisplayed();
	}
	
	
	public LoginPage clickInloggning() {   //open page to enter usr/pwd to login
		inloggning.click();
		return new LoginPage();
	}
}
