package com.tacx.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tacx.base.TestBase;
import com.tacx.pages.CreateWorkoutPage;
import com.tacx.pages.DistanceSelectionPage;

public class DistanceSelectionPageTest extends TestBase

{
	DistanceSelectionPageTest distanceselectionpagetest;
	DistanceSelectionPage distanceselectionpage;
	CreateWorkoutPage createworkoutpage;

	public DistanceSelectionPageTest() {
		super();
	}

	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {
		intialization();
		login();
		createworkoutpage = new CreateWorkoutPage();
		distanceselectionpage = createworkoutpage.verifyClickOnContinue();
		distanceselectionpagetest = new DistanceSelectionPageTest();
	}

	@Test(groups = "Regression")
	public void verifyCreateText() {
		log.info("First-TestCase: Verify URL Link ");
		String titletext = distanceselectionpage.verifylandingPageOfSelectDistance();
		assertEquals(titletext, "Create");
	}

	@Test(groups = "Regression")
	public void verifyDistanceValue() {
		log.info("First-TestCase: Verify URL Link ");
		String updtedSetValue = distanceselectionpage.verifyDistanceValue();
		assertEquals(updtedSetValue, "12.0");
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
