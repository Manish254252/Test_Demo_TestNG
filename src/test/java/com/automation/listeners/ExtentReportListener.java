package com.automation.listeners;

import com.automation.test.BaseTest;
import com.automation.utils.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtentReportListener implements ITestListener {

//
    @Override
    public void onStart(ITestContext context) {
    ExtentReportManager.initExtentReport();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentReportManager.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentReportManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentReportManager.getTest().pass("Test passed");
        ExtentReportManager.attachScreenShot();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentReportManager.attachScreenShot();
        ExtentReportManager.getTest().fail("Test failed \n"+result.getThrowable().getMessage());

    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }
}

