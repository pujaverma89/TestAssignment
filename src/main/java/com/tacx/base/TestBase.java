package com.tacx.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import com.tacx.utils.TestUtils;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static Logger log = Logger.getLogger(TestBase.class);

	public TestBase() {

		// code to access properties file
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/tacx/config/config.properties");
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// webdriver intialization
	// browser name can be change by properties file
	public static void intialization() {

		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/TestAssignmentTacx/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "/TestAssignmentTacx/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtils.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtils.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}

	// login details
	public static void login() throws InterruptedException {
		driver.get(prop.getProperty("urlLogin"));
		String loginusername = prop.getProperty("loginemail");
		driver.findElement(By.id("email")).sendKeys(loginusername);
		String loginpassword = prop.getProperty("loginpassword");
		driver.findElement(By.id("password")).sendKeys(loginpassword);
		driver.findElement(By.id("login")).click();
		Thread.sleep(2000);
	}

	// Screenshot utilities
	public void takeScreenShotFailedTc(String testMethodName) {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(srcfile, new File("TestAssignmentTacx/" + testMethodName + "_" + ".jpg"));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
