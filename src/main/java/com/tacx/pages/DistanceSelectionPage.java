package com.tacx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tacx.base.TestBase;

public class DistanceSelectionPage extends TestBase {
	CreateWorkoutPage createworkoutpage;
   
	//pathdeclaration of elements for distance calculateapage
	@FindBy(xpath = "//h2[contains(text(),'Create')]")
	WebElement createText;

	@FindBy(xpath = "//body/section[3]/md-content[1]/div[3]/div[1]/div[1]/div[1]/md-toolbar[2]/div[1]/div[2]/div[1]")
	WebElement distanceValue;

	@FindBy(xpath = "//body/section[3]/md-content[1]/div[3]/div[1]/div[1]/div[1]/md-toolbar[2]/div[1]/div[2]/div[2]/button[1]/ng-md-icon[1]/*[1]")
	WebElement cursarValueIncrement;

	@FindBy(xpath = "//body/section[3]/md-content[1]/div[3]/div[1]/div[1]/div[1]/md-toolbar[2]/div[1]/div[2]/div[2]/button[2]/ng-md-icon[1]/*[1]")
	WebElement cursarValueDecrement;

	@FindBy(xpath = "//body/section[3]/md-content[1]/div[3]/div[1]/div[1]/div[1]/md-toolbar[1]/div[1]/button[10]")
	WebElement saveButton;

	@FindBy(xpath = "/html[1]/body[1]/div[3]/md-dialog[1]/md-dialog-content[1]/form[1]/md-input-container[1]/input[1]")
	WebElement workoutSaveByName;

	@FindBy(xpath = "//body/div[3]/md-dialog[1]/md-dialog-actions[1]/button[2]")
	WebElement saveButtonClick;

	// intiate the pageObjects
	public DistanceSelectionPage() {
		PageFactory.initElements(driver, this);
	}

	//check pagetitletext
	public String verifylandingPageOfSelectDistance() {
		return createText.getText();
	}
 
	//calculatethedistance and make it 12
	public String verifyDistanceValue() {
		float diff = 0;
		String str = distanceValue.getText();
		String st[] = str.split(" ", 2);
		// for (String a : st)
		// System.out.println(a);
		float f = Float.parseFloat(st[0]);
		System.out.println(f);
		if (f <= 12) {
			diff = (float) (12.0 - f) * 10;
			for (int i = 0; i < diff; i++) {
				cursarValueIncrement.click();
			}
		}
		// justToCheck if negative loop work
		else if (f >= 12) {
			diff = (float) (f - 12.0) * 10;
			for (int i = 0; i < diff; i++) {
				cursarValueDecrement.click();
				// TO DO Decrement value goes here cursarValue.click();
			}
		}
		String updatedValue = distanceValue.getText();
		String st1[] = updatedValue.split(" ", 2);
		return st1[0];
	}
    
	//savebutton and redirect to workoutpage to check if workout exits
	public WorkoutsPage verifySaveButton() {
		verifyDistanceValue();
		saveButton.click();
		workoutSaveByName.sendKeys("MyFirstWorkOut");
		saveButtonClick.click();
		return new WorkoutsPage();

	}

}