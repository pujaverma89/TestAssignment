package com.tacx.testcases;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tacx.base.TestBase;
import com.tacx.pages.CreateWorkoutPage;
import com.tacx.pages.HomePage;
public class CreateWorkoutTest extends TestBase {  
	
	CreateWorkoutPage createworkoutpage;  
	CreateWorkoutTest createworkoutpagetest;
	HomePageTest homepagetest;
	HomePage homepage;
	
	public CreateWorkoutTest() {
		super();
	}
	@BeforeMethod(alwaysRun = true)
	public void setup() throws InterruptedException { 
		intialization(); 
		login(); 
		createworkoutpage = new CreateWorkoutPage();
		createworkoutpagetest = new CreateWorkoutTest();	    
		}  	
	@Test(groups = "Regression")
	public void verifyDashBoardUrl() throws InterruptedException {
		log.info("TestCase: Verify URL Link ");
		Thread.sleep(1000);
		String titletext = createworkoutpage.verifyCreateWorkoutpageTedirected();
		assertEquals(titletext, "Create Workout");
	}  	
	@Test(groups = "Regression")
	public void verifyDistanceClicked() throws InterruptedException {
		log.info("TestCase: Verify continueto new workoutsetup");
		createworkoutpage.verifyClickOnContinue();
	}	
	@AfterMethod(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}
	}
