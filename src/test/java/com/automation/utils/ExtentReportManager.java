package com.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ExtentReportManager {
    private static ExtentReports extent;
    private static ExtentTest test;
    static ExtentSparkReporter htmlReporter;

    public static void initExtentReport() {
        htmlReporter = new ExtentSparkReporter("ExtentReports/ExtentReport.html");
        htmlReporter.config().setDocumentTitle("Automation Test Report");
        htmlReporter.config().setReportName("TestNG Test Report");
        htmlReporter.config().setTheme(Theme.STANDARD);

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    public static void flush() {
        extent.flush();
    }

    public static void createTest(String name) {
        test = extent.createTest(name);
    }

    public static ExtentTest getTest() {
        return test;
    }
public static void attachScreenShot()
{
    test.addScreenCaptureFromPath(takeScreenshot());
}
    public static String takeScreenshot() {

        System.out.println("Entre Screenshot");
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        File file = ts.getScreenshotAs(OutputType.FILE);
        Random random = new Random();
        int a = random.nextInt(1000);
        String filePath = "src/test/resources" + "/screenshot" + a + ".png";
        try {
            FileUtils.copyFile(file, new File(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       return System.getProperty("user.dir")+"/"+filePath;
    }

}
