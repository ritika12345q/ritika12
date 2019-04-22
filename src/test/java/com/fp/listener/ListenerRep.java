package com.fp.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.fp.utilities.TestUtilitiesMethods;
import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;

public class ListenerRep extends BaseClass implements ITestListener{
	
	public void onTestStart(ITestResult result) {
           test = rep.startTest(result.getName().toUpperCase());
           System.out.println("Test Case Started: "+result.getName());

	}

	public void onTestSuccess(ITestResult result) {
		test.log(LogStatus.PASS, result.getName().toUpperCase()+" PASS");
		rep.endTest(test);
		rep.flush();
		
	}

	public void onTestFailure(ITestResult result) {
		
		TestUtilitiesMethods.takeScreenShot();
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+" FAIL");
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtilitiesMethods.screenshotName));

		Reporter.log("Click on the below link to see Screenshot:");
        Reporter.log("<a target=\"_blank\" href="+TestUtilitiesMethods.screenshotName+">Screnshot link</a>");
		rep.endTest(test);
		rep.flush();
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName().toUpperCase()+" Skipped");
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
