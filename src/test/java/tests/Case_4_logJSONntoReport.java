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

public class Case_4_logJSONntoReport {
	public static void main(String[] args) throws IOException {

		ExtentReports extentReports = new ExtentReports();

		File file = new File("D:\\Selenium Projects\\ExtenceReportProject\\ExtentReports_XMLContent\\ereport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

		extentReports.attachReporter(sparkReporter);

		String xmlContent="{\"menu\": {\r\n"
				+ "  \"id\": \"file\",\r\n"
				+ "  \"value\": \"File\",\r\n"
				+ "  \"popup\": {\r\n"
				+ "    \"menuitem\": [\r\n"
				+ "      {\"value\": \"New\", \"onclick\": \"CreateNewDoc()\"},\r\n"
				+ "      {\"value\": \"Open\", \"onclick\": \"OpenDoc()\"},\r\n"
				+ "      {\"value\": \"Close\", \"onclick\": \"CloseDoc()\"}\r\n"
				+ "    ]\r\n"
				+ "  }\r\n"
				+ "}}";
		
		ExtentTest eTest1 = extentReports.createTest("TestOne");
		// eTest1.pass("Test One is Passed SuccessFully");
		//eTest1.log(Status.PASS, "Test One is Passed");

		eTest1.log(Status.INFO,MarkupHelper.createCodeBlock(xmlContent,CodeLanguage.JSON));
		

		extentReports.flush();

		Desktop.getDesktop().browse(file.toURI());
	}
}
