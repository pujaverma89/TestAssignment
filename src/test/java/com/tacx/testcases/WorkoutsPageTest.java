package com.tacx.testcases;

import static org.junit.Assert.assertArrayEquals;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tacx.base.TestBase;
import com.tacx.pages.CreateWorkoutPage;
import com.tacx.pages.DistanceSelectionPage;
import com.tacx.pages.WorkoutsPage;

public class WorkoutsPageTest extends TestBase {

	DistanceSelectionPage distanceselectionpage;
	WorkoutsPage workoutpage;
	WorkoutsPageTest workoutpagetest;
	CreateWorkoutPage createworkoutpage;

	public WorkoutsPageTest() {
		super();
	}
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException {
		intialization();
		login();
		createworkoutpage = new CreateWorkoutPage();
		distanceselectionpage = createworkoutpage.verifyClickOnContinue();
		distanceselectionpage = new DistanceSelectionPage();
		workoutpage = distanceselectionpage.verifySaveButton();
		workoutpagetest = new WorkoutsPageTest();
	}
	@Test(groups = "Regression")
	public void verifyTitleAndWorkOutName() {
		log.info("First-TestCase: Verify URL Link ");
		String titletext = workoutpage.verifyWorkoutsPagetitle();
		assertEquals(titletext, "Workouts");
	}
	@Test(groups = "Regression")
	public void verifyWorkoutTitleName() {
		log.info("First-TestCase: Verify Name after create workout ");
		String workoutName = workoutpage.verifyWorkOutName();
		System.out.println("Display all workoutName   :::::" + workoutName);
		Assert.assertTrue(workoutName.contains("MyFirstWorkOut"));
		// assertEquals(workoutName, "MyFirstWorkOut");
		workoutpage.signOut();
	}
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
}
