package com.tacx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tacx.base.TestBase;

public class CreateAccountPage extends TestBase {

	// pageclass for account creation
	@FindBy(id = "firstName")
	WebElement firstname;

	@FindBy(id = "email")
	WebElement email;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "repeatPassword")
	WebElement repeatpassword;

	@FindBy(xpath = "//body/section[2]/div[1]/md-content[1]/div[3]/form[1]/md-checkbox[1]/div[1]")
	WebElement checkBox;

	@FindBy(id = "confirmAge")
	WebElement checkbox2;

	@FindBy(xpath = "/html[1]/body[1]/section[2]/div[1]/md-content[1]/div[3]/form[1]/button[1]")
	WebElement signupbutton;

	@FindBy(xpath = "//div[@id='emailFeedback']")
	WebElement userAlredyExits;

	//intiate the pageObjects
	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateHomePagetitle() {
		return driver.getTitle();
	}

	//input details to createaccountdetails
	public SignupPage verifyAccountCreationDetails() throws InterruptedException {
		Thread.sleep(2000);
		String firstName = prop.getProperty("firstname");
		firstname.sendKeys(firstName);
		String eMail = prop.getProperty("email");
		email.sendKeys(eMail);
		String passward = prop.getProperty("password");
		password.sendKeys(passward);
		String repeatPassward = prop.getProperty("repeatpassword");
		repeatpassword.sendKeys(repeatPassward);
		checkBox.click();
		checkbox2.click();
		signupbutton.click();
		return new SignupPage();
	}

	// Check if exiting user can create same account with same name.
	public String verifyUserAlreadyExits() throws InterruptedException {
		Thread.sleep(2000);
		String firstName = prop.getProperty("firstname");
		firstname.sendKeys(firstName);
		String eMail = prop.getProperty("email");
		email.sendKeys(eMail);
		String passward = prop.getProperty("password");
		password.sendKeys(passward);
		String repeatPassward = prop.getProperty("repeatpassword");
		repeatpassword.sendKeys(repeatPassward);
		checkBox.click();
		checkbox2.click();
		signupbutton.click();
		String validationMessage = userAlredyExits.getText();
		return validationMessage;
	}

}
