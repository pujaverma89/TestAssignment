package com.tacx.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tacx.base.TestBase;
import com.tacx.pages.SignupPage;

public class SignupPageTest extends TestBase {

	SignupPageTest signuppagetest;
	SignupPage signuppage;

	public SignupPageTest() {
		super();
	}
	@BeforeMethod(alwaysRun = true)
	public void setup() {
		intialization();
		signuppage = new SignupPage();
	}
	//  Test Creation
	@Test(groups = "Regression")
	public void verifyHomePageTitleTest() {
		log.info("First-TestCase: Verify HomePage Title ");
		String title = signuppage.validateHomePagetitle();
		Assert.assertEquals(title, "Tacx Cloud: login", "HomePage title matched");
	}
	@Test(groups = "Regression")
	public void verifyCreateAccountButtonRedirectsToCreatePage() {
		log.info("First-TestCase: Verify CreateAccountLink ");
		signuppage.clickOnCreateAccount();
		System.out.println("Redirect to creation page");
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
