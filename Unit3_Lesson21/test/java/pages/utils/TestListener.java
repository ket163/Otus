package pages.utils;

import static com.codeborne.selenide.Selenide.getWebDriverLogs;

import org.apache.log4j.Logger;

import org.openqa.selenium.logging.LogType;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.*;
import java.util.List;
import java.util.logging.Level;

import static com.codeborne.selenide.Selenide.screenshot;

public class TestListener implements ITestListener {

    static Logger logger = Logger.getLogger(TestListener.class);


    public void onTestStart(ITestResult result) {

        logger.info(" log4g - Test started");

    }

    public void onTestSuccess(ITestResult result) {

        logger.info("log4g - Test successfully passed!");
    }

    public void onTestFailure(ITestResult result) {





        /*                               /build/reports/tests                                                       */
        screenshot("MY_SCREEN");


        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        Throwable reason = result.getThrowable();
        reason.printStackTrace(pw);
        logger.error(result.getTestClass());
        logger.error(result.getTestName());
        logger.error(sw.getBuffer().toString());


    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {


    }

    public void onFinish(ITestContext context) {

        //Perfomance doesn't work properly now at selenide.Issue are opened on github.So i use Browser
        //https://github.com/codeborne/selenide/issues/586

        List<String> logEntries = getWebDriverLogs(LogType.BROWSER, Level.ALL);
        String filePath = "build/reports/tests/TrafficHandler.txt";
        try (final FileWriter writer = new FileWriter(filePath, true)) {
            for (String entry : logEntries) {
                writer.write(String.valueOf(entry));
                writer.write(System.lineSeparator());
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
