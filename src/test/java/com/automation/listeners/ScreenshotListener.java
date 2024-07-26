package com.automation.listeners;



import com.automation.test.BaseTest;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
      BaseTest.takeScreenShot();
    }

}

