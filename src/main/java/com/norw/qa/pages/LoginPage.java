package com.norw.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.norw.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory or Object Repository
	@FindBy(xpath="//input[@id='username']")
	WebElement usrname;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement passw;
	
	@FindBy(xpath="//button[contains(text(),'Logga in')]")
	WebElement btnLoggaIn;
	
	
	//Initializing Page Objects
	public LoginPage() {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public boolean loggaInDisp() { 			
		return btnLoggaIn.isDisplayed();
	}
	
	public boolean checkUsername() {
		return usrname.isDisplayed();
	}
	
	public boolean checkPassword() {
		return passw.isDisplayed();
	}
	
	//called from ChooseFlightsDestDatesPageTest in its setUp()
		public ChooseFlightDestDatesPage loging(String usr, String pw) throws InterruptedException {
			usrname.sendKeys(usr);
			passw.sendKeys(pw);
			Thread.sleep(5000);
			btnLoggaIn.click();
			Thread.sleep(5000);
			return new ChooseFlightDestDatesPage();
		}
	
}
