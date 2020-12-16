package com.tacx.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.model.Test;
import com.tacx.base.TestBase;

public class WorkoutsPage extends TestBase {
	@FindBy(xpath = "//h2[contains(text(),'Workouts')]")
	WebElement workoutsPageTitle;

//	@FindBy(xpath="/html[1]/body[1]/section[3]/md-content[1]/div[3]/div[1]/div[1]/div[1]/div[2]/div[1]/md-card[1]/md-card-content[1]/a[1]/div[1]/div[1]/div[2]/div[1]/h4[1]/div[1]")
//	WebElement workoutsName; 
//	
	@FindBy(xpath = "//div[@id='workouts-cards']")
	WebElement workoutsName;

	@FindBy(xpath = "//div[contains(text(),'Sign Out')]")
	WebElement signout;

	// intiate the pageObjects
	public WorkoutsPage() {
		PageFactory.initElements(driver, this);
	}
	public String verifyWorkoutsPagetitle() {
		return workoutsPageTitle.getText();
	}
	public String verifyWorkOutName() {
		return workoutsName.getText();
	}
	public void signOut() {
		signout.click();
	}
}
