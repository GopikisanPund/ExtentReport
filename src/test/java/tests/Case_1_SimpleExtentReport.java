package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Case_1_SimpleExtentReport {

    public static void main(String[] args) throws IOException {

        ExtentReports extentReports = new ExtentReports();

        File file = new File("D:\\Selenium Projects\\ExtenceReportProject\\ExtentReports\\ereport.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        
        extentReports.attachReporter(sparkReporter);
        
        ExtentTest eTest1 = extentReports.createTest("TestOne");
        //eTest1.pass("Test One is Passed SuccessFully");
        eTest1.log(Status.PASS,"Test One is Passed");
        
        ExtentTest eTest2 = extentReports.createTest("TestSecond");
        //eTest2.fail("Test Tow is Passd Successfulyy");
        eTest2.log(Status.FAIL,"Test One is Faild");
        
        ExtentTest eTest3 = extentReports.createTest("TestSecond");
        //eTest2.fail("Test Tow is Passd Successfulyy");
        eTest3.log(Status.SKIP,"Test One is Skip");
        
        extentReports.flush();
        
        Desktop.getDesktop().browse(file.toURI());
    }

}
