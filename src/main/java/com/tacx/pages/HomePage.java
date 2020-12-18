package com.tacx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tacx.base.TestBase;

public class HomePage extends TestBase {

	// afterlogin redirects to homepage
	// path declaration for homepage
	@FindBy(xpath = "//a[@id='sidenav-logo']")
	WebElement dashBoardPageLogo;

	@FindBy(xpath = "//body/section[3]/md-sidenav[1]/div[1]/md-content[1]/ul[1]/sidenav-section[1]/ul[1]/li[4]/button[1]xx")
	WebElement createWorkoutLink;

	// intiate the pageObjects
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// WebElement Actions
	public String VerifyUrlAppDashboard() throws InterruptedException {
		Thread.sleep(2000);
		return driver.getCurrentUrl();
	}

	// test to checklogo availible on homepage
	public Boolean verifyTacxLogoDisplay() throws InterruptedException {
		Thread.sleep(2000);
		return dashBoardPageLogo.isDisplayed();
	}

	// createworkutlink
	// redirecttoDistance createworkoutpage
	public CreateWorkoutPage verifyWorkoutLinkRedirect() throws InterruptedException {
		createWorkoutLink.click();
		Thread.sleep(1000);
		return new CreateWorkoutPage();

	}

}
