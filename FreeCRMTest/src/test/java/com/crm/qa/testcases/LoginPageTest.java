package com.crm.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPageTest extends TestBase {

//	public LoginPageTest() {
//		super();
//	}

	WebDriver driver;
	SoftAssert sa;
	LoginPage objLoginPage;
	HomePage objHomePage;

	@BeforeTest
	public void setup() {
		initialization();
	
		driver=super.driver;
		
		 objLoginPage = new LoginPage(driver);
		 
	
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		driver.get(prop.getProperty("url"));
		
		

		sa = new SoftAssert();
	}

	@Test(priority = 1)
	public void titleTest() {
		String title = objLoginPage.validateLoginPageTitle();
		sa.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
	}

	@Test(priority = 2)
	public void crmLogoImageTest() {
		boolean flag = objLoginPage.validateCRMImage();
		sa.assertTrue(flag);

	}

	@Test(priority = 3)
	public void loginTest() {
		objHomePage = objLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@AfterTest()
	public void teardown() {
		driver.quit();
	}
}
