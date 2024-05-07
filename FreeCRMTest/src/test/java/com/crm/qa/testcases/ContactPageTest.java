package com.crm.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactPageTest extends TestBase{

	WebDriver driver;
	SoftAssert sa;
	LoginPage objLoginPage;
	HomePage objHomePage;
	ContactsPage objContactPage;
	TestUtil objTestUtil;
	String sheetName="contacts";
	
	
	@BeforeTest
	public void setup() {
		initialization();
		driver=super.driver;
		sa=new SoftAssert();
		objLoginPage=new LoginPage(driver);
		objContactPage=new ContactsPage(driver);
		objHomePage=new HomePage(driver);
		objTestUtil=new TestUtil(driver);
		objHomePage = objLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		objTestUtil.swithToFrame();
		objContactPage=objHomePage.clickOnContactsLink();
		
	}
	

	
	@Test(priority=1)
	public void verifyContactLabel() {
		sa.assertTrue(objContactPage.verifyContactHeading()); 
	}
	
	@Test(priority=2)
	public void verifySelectContactList() {
		objContactPage.selectContactByName("Max Doe");
		
	}
	
	@Test(priority=3)
	public void multipleCheckBoxSelect() {
		objContactPage.selectContactByName("Max Doe");
		objContactPage.selectContactByName("Matin Peter");
	}
	

	@DataProvider
	public Object[][] getCRMTestData() {
	Object data[][]=	TestUtil.getTestData(sheetName);
	return data;
	}
	
	@Test(priority=4,dataProvider="getCRMTestData")
	public void verifyCreateContact(String title,String firstName,String lastName,String company) {
		objHomePage.clickonNewContact();
//		objContactPage.createNewContact("Miss","Teyana","Omi","Google");
		objContactPage.createNewContact(title, firstName, lastName, company);
	}
	
	
	@AfterTest
	public void tearDown() {
		sa.assertAll();
		driver.quit();
	}
	
}
