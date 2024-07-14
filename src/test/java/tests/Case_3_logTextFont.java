package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Case_3_logTextFont 
{
	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();

		File file = new File("D:\\Selenium Projects\\ExtenceReportProject\\ExtentReports_levels\\ereport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		extentReports.attachReporter(sparkReporter);

		ExtentTest eTest1 = extentReports.createTest("<i>Test One Check the Fonts</i>");
		// eTest1.pass("Test One is Passed SuccessFully");
		eTest1.log(Status.PASS, "Test One is Passed");

		eTest1.log(Status.INFO, "This is info its shows info");
		eTest1.log(Status.PASS, "Test is passed");
		eTest1.log(Status.WARNING, "This is warning");
		eTest1.log(Status.SKIP, "Test is skiped");
		eTest1.log(Status.FAIL, "Test is Failed");

		extentReports.flush();

		Desktop.getDesktop().browse(file.toURI());
	}

}
