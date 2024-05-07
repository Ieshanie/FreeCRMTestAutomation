package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	By userNameLabel= By.xpath("//td[contains(text(), 'User')]");
	By contactsLink=By.xpath("//a[contains(text(), 'Contacts')]");
	By dealsLink=By.xpath("//a[contains(text(), 'Deals')]");
	By tasksLink=By.xpath("//a[contains(text(), 'Tasks')]");
	By newContact=By.xpath("//a[contains(text(),'New Contact')]");
	
	//Initializing the Page Object
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}

	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return driver.findElement(userNameLabel).isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink() {
		 driver.findElement(contactsLink).click();
		 return new ContactsPage(driver);
	}
	
	public DealsPage clickOnDealsLink() {
		driver.findElement(dealsLink).click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink() {
		driver.findElement(tasksLink);
		return new TasksPage();
	}
	
	public void clickonNewContact() {
		Actions action=new Actions(driver);
		action.moveToElement(driver.findElement(contactsLink)).build().perform();
		driver.findElement(newContact).click();
	}
	
}
