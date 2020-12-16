package com.tacx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tacx.base.TestBase;

public class CreateWorkoutPage extends TestBase {

	@FindBy(xpath = "/html[1]/body[1]/section[3]/md-sidenav[1]/div[1]/md-content[1]/ul[1]/sidenav-section[1]/ul[1]/li[4]/button[1]/div[1]")
	WebElement createWorkoutText;

	@FindBy(xpath = "/html[1]/body[1]/section[3]/md-content[1]/div[3]/div[1]/div[1]/section[1]/div[1]/button[2]/div[1]/img[1]")
	WebElement powerworkout;

	@FindBy(xpath = "//body/section[3]/md-content[1]/div[3]/div[1]/div[1]/section[2]/div[1]/button[2]/div[1]/img[1]")
	WebElement distance;

	@FindBy(xpath = "//body/section[3]/md-content[1]/div[3]/div[1]/div[1]/section[3]/button[1]")
	WebElement continueButton;

	// intiate the pageObjects
	public CreateWorkoutPage() {
		PageFactory.initElements(driver, this);
	}

	// WebElement Actions
	public String verifyCreateWorkoutpageTedirected() throws InterruptedException {
		return createWorkoutText.getText();
	}

	public DistanceSelectionPage verifyClickOnContinue() {
		createWorkoutText.click();
		powerworkout.click();
		distance.click();
		continueButton.click();
		return new DistanceSelectionPage();
	}

}
