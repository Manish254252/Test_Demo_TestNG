package com.automation.utils;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class AllureReportManager {
//    @Attachment(type = "image/png")
    public static void attachScreenShot() {
        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();
        Allure.addAttachment("ScreenShot",new ByteArrayInputStream(ts.getScreenshotAs(OutputType.BYTES)));
    }

    public static  void log(String msg)
    {
       Allure.addAttachment("Test failed",msg);
    }
}
