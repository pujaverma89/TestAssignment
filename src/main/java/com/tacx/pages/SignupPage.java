package com.tacx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tacx.base.TestBase;

public class SignupPage extends TestBase {

	// xpathelement calling
	// before click on createaccount page text verification
	@FindBy(xpath = "//*[contains(@class, 'message ng-binding')]")
	WebElement messageverify;
	@FindBy(xpath = "//button[contains(text(),'Create account')] ")
	WebElement createAccountButtonClick;

	// intiate the pageObjects
	public SignupPage() {
		PageFactory.initElements(driver, this);
	}

	// WebElement Actions
	public String validateHomePagetitle() {
		return driver.getTitle();
	}

	public String PageLoadSucessfullyCheck() {
		return messageverify.getText();
	}

	public CreateAccountPage clickOnCreateAccount() {
		createAccountButtonClick.click();
		return new CreateAccountPage();
	}

}