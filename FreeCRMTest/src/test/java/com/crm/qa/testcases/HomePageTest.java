package com.crm.qa.testcases;

import org.bouncycastle.jcajce.provider.asymmetric.dsa.BCDSAPrivateKey;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	WebDriver driver;
	SoftAssert sa;
	HomePage objHomePage;
	LoginPage objLoginPage;
	TestUtil objTestUtil;
	ContactsPage objContactPage;
	

	@BeforeTest
	public void setup() {
		initialization();
		driver = super.driver;
		sa = new SoftAssert();
		objTestUtil=new TestUtil(driver);
		objContactPage=new ContactsPage(driver);
	
		objLoginPage = new LoginPage(driver);
		// objHomePage=new HomePage(driver);
		objHomePage = objLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void verifyHomePageTestTitle() {
		String HomePageTitle = objHomePage.verifyHomePageTitle();
		sa.assertEquals(HomePageTitle, "CRMPRO", "Home PageTitle is not Match");
	}

	@Test(priority = 2)
	public void verifyUserNameTest() {
		objTestUtil.swithToFrame();
		sa.assertTrue(objHomePage.verifyCorrectUserName());
	}
	
	
	@Test(priority=3)
	public void verifyContactPageLink() {
		objContactPage=objHomePage.clickOnContactsLink();
		
		
	}

	@AfterTest
	public void tearDown() {
		sa.assertAll();
		driver.quit();

	}
}
