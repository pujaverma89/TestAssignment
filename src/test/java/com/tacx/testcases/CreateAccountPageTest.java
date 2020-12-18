package com.tacx.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tacx.base.TestBase;
import com.tacx.pages.CreateAccountPage;
import com.tacx.pages.SignupPage;

public class CreateAccountPageTest extends TestBase {
	SignupPage signuppage;
	CreateAccountPage createaccountpage;

	public CreateAccountPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() {
		intialization();
		signuppage = new SignupPage();
		createaccountpage = signuppage.clickOnCreateAccount();
	}

	// access and verify usercreated succesfully
	@Test(groups = "Regression")
	public void verifyAccountsCreatedSucessfully() throws InterruptedException {
		log.info("TestCase: VerifyAccount created successfully ");
		createaccountpage.verifyAccountCreationDetails();
	}

	// check if useralready exits can create new account
	@Test(groups = "Regression")
	public void verifyUserAlreadyExitsMessage() throws InterruptedException {
		log.info("TestCase: Verify validation message for user already exits");
		String validationCheck = createaccountpage.verifyUserAlreadyExits();
		Assert.assertEquals(validationCheck, "");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
