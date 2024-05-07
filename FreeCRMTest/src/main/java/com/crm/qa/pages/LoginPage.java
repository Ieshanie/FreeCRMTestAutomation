package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	WebDriver driver;
	
	
	By username=By.name("username");
	By password=By.name("password");
	By login=By.xpath("//input[@value='Login']");
	By signUp=By.xpath("//a [text()='Sign Up']");
	By crmLogo=By.xpath("//a[@class='navbar-brand']");

	//Constructor Overload
	public LoginPage (WebDriver driver){
		this.driver=driver;
	}
	
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateCRMImage() {
		 return driver.findElement(crmLogo).isDisplayed();
				//driver.findElement(username).sendKeys(strUserName);
		
	}
	
	public HomePage login(String strusername, String strpassword) {
		driver.findElement(username).sendKeys(strusername);
		driver.findElement(password).sendKeys(strpassword);
		driver.findElement(login).click();
		return new HomePage(driver);
		
	}
}
