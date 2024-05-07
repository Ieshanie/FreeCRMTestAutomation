package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;


public class ContactsPage extends TestBase{

	public ContactsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By ContactHeading=By.xpath("//td[contains(text(),'Contacts')]");
	By firstName=By.id("first_name");
	By lastName=By.id("surname");
	By company=By.name("client_lookup");
	By submit=By.xpath("//input[@name='addmore']/preceding-sibling::input[@value='Save']");
	

	
	
	
	public boolean verifyContactHeading() {
	return	driver.findElement(ContactHeading).isDisplayed();
	}
	
	public void selectContactByName(String name) {
		driver.findElement(By.xpath("//a[text()='"+name+"']/ancestor::td[@class='datalistrow']/preceding-sibling::td[@class='datalistrow'][1]/input[@type='checkbox']")).click();
	}
	
	public void createNewContact(String title,String fname, String lname,String com) {
		Select select=new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(company).sendKeys(com);
		driver.findElement(submit).click();
		
	}

}
