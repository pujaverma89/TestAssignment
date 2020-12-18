package com.tacx.testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tacx.base.TestBase;
import com.tacx.pages.CreateAccountPage;
import com.tacx.pages.HomePage;
import com.tacx.pages.SignupPage;

public class HomePageTest extends TestBase {

	CreateAccountPage createaccountpage;
	HomePage homepage;

	public HomePageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {
		intialization();
		login();
		homepage = new HomePage();
		
	}

	@Test(groups = "Regression")
	public void verifyDashBoardUrl() throws InterruptedException {
		log.info("First-TestCase: Verify URL Link ");
		// String url = homepage.VerifyUrlAppDashboard();
		String url = driver.getCurrentUrl();
		assertEquals(url, "https://cloud.tacx.com/#/dashboard");
	}

	@Test(groups = "Regression")
	public void verifyTacxLogo() throws InterruptedException {
		log.info("First-TestCase: Verify URL Link ");
		Boolean flag = homepage.verifyTacxLogoDisplay();
		Thread.sleep(1000);
		Assert.assertTrue(flag, "logo not avalible");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
