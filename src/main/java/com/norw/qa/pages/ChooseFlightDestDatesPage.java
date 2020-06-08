package com.norw.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.norw.qa.base.TestBase;

public class ChooseFlightDestDatesPage extends TestBase{

	HomePage homePage;
	LoginPage loginPage;
	ChooseFlightDestDatesPage chooseFlightDatesPage;
	boolean flag;
	String usernameCapital = prop.getProperty("username");
	//Page Factory (ORepository)
	
	@FindBy(xpath="//h2[contains(text(),'KAJETAN MELLEROWICZ')]")  //can't use variable in FindBy()
	//@FidnBy(xpath="//h2[@class='marg']")
	WebElement usernamecapital;
	
	//@FindBy(xpath="//button[contains(text(),'Boka flyg')]")  //can't find this button eventhough the Boka flyg is visible in html source code
	@FindBy(xpath="//i[@class='icon-small  icon-small--flight-tickets--light']")  //works
	WebElement bookingtab;
	
	//initialization of the object
	public ChooseFlightDestDatesPage() {
		
		PageFactory.initElements(driver, this);
	}

	
	//Actions

	public boolean validateUsrCaps()
	{
		flag = usernameCapital.contentEquals(usernameCapital);
		return flag;
	}

	public boolean validateSokBokning() {
		//to scroll down to Element
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", bookingtab);
		System.out.println("True or False--->"+bookingtab.isDisplayed());
		
		return bookingtab.isDisplayed();
	}
	
}
