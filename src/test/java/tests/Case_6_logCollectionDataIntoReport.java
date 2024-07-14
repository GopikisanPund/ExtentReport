package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Case_6_logCollectionDataIntoReport {

	public static void main(String[] args) {
		
		ExtentReports extentReports = new ExtentReports();

		File file = new File("D:\\Selenium Projects\\ExtenceReportProject\\ExtentReports_JSONContent\\ereport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		extentReports.attachReporter(sparkReporter);

		ArrayList<String> List=new ArrayList<String>();
		List.add("Sunday");
		List.add("Monday");
		List.add("Tuesdays");
		List.add("wednedays");
		List.add("thirsday");
		List.add("Friday");
		List.add("Saturdays");
			
		ExtentTest eTest1 = extentReports.createTest("TestOne");
		// eTest1.pass("Test One is Passed SuccessFully");
		//eTest1.log(Status.PASS, "Test One is Passed");

		eTest1.log(Status.INFO,MarkupHelper.createOrderedList(List));
		
		ArrayList<String> List2=new ArrayList<String>();
		List2.add("Red");
		List2.add("Black");
		List2.add("Yello");
		List2.add("Green");
		List2.add("white");
		List2.add("perpole");
		List2.add("greeen");
			
		ExtentTest eTest2 = extentReports.createTest("TestTwo");
		// eTest1.pass("Test One is Passed SuccessFully");
		//eTest1.log(Status.PASS, "Test One is Passed");

		eTest2.log(Status.INFO,MarkupHelper.createOrderedList(List2));
		

		extentReports.flush();

		try {
			Desktop.getDesktop().browse(file.toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
