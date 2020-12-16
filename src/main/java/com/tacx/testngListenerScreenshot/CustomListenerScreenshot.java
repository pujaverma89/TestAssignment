package com.tacx.testngListenerScreenshot;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.tacx.base.TestBase;


public class CustomListenerScreenshot  extends TestBase implements ITestListener{ 
	
	@Override
	public void onTestStart(ITestResult result) {
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Failed TestCases");
		takeScreenShotFailedTc(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {

	}
}



