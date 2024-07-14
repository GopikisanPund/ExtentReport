package tests;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Case_5_logXMLontentLogIntoReport 
{
	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();

		File file = new File("D:\\Selenium Projects\\ExtenceReportProject\\ExtentReports_JSONContent\\ereport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		extentReports.attachReporter(sparkReporter);

		String xmlContent="<menu id=\"file\" value=\"File\">\r\n"
				+ "  <popup>\r\n"
				+ "    <menuitem value=\"New\" onclick=\"CreateNewDoc()\" />\r\n"
				+ "    <menuitem value=\"Open\" onclick=\"OpenDoc()\" />\r\n"
				+ "    <menuitem value=\"Close\" onclick=\"CloseDoc()\" />\r\n"
				+ "  </popup>\r\n"
				+ "</menu>";
		
		ExtentTest eTest1 = extentReports.createTest("TestOne");
		// eTest1.pass("Test One is Passed SuccessFully");
		//eTest1.log(Status.PASS, "Test One is Passed");

		eTest1.log(Status.INFO,MarkupHelper.createCodeBlock(xmlContent,CodeLanguage.XML));
		

		extentReports.flush();

		Desktop.getDesktop().browse(file.toURI());
	}


}
