package com.tacx.utils;

import org.openqa.selenium.Alert;

import com.tacx.base.TestBase;

public class TestUtils extends TestBase {
	public static long Page_Load_Timeout = 25;
	public static long Implicit_Wait = 15;
	public static long explicit_wait = 10;

	public void handleCookieAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
}
