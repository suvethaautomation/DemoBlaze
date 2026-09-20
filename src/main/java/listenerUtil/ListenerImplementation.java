package listenerUtil;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import genUtility.BaseClass;

public class ListenerImplementation implements ITestListener, ISuiteListener {

	public ExtentSparkReporter spark;
	public ExtentReports report;
	public ExtentTest test;
	
	@Override
	public void onStart(ISuite suite)
	{
		Reporter.log("Report configuration",true);
		Date d=new Date();
		String newDate = d.toString().replace(" ", "_").replace(":", "_");
		spark=new ExtentSparkReporter("./AdvanceReports/report" + newDate + ".html");
		
		spark.config().setDocumentTitle("DemoBlaze Test Results");
		spark.config().setReportName("DEMOBLAZE");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows 11");
		report.setSystemInfo("Browser", "Edge");
	
	}
	
	@Override
	public void onFinish(ISuite suite)
	{
		report.flush();
		Reporter.log("Report backup",true);
	}
	
	@Override
	public void onTestStart(ITestResult result)
	{
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, "======="+result.getMethod().getMethodName()+"Execution started");
	}
	
	@Override
	public void onTestSuccess(ITestResult result)
	{
		test.log(Status.INFO, "======="+result.getMethod().getMethodName()+"SUCESS===");
	}
	
	@Override
	public void onTestFailure(ITestResult result)
	{
		String testName = result.getMethod().getMethodName();
		Reporter.log("====="+testName+"FAILURE",true);
		Date d=new Date();
		String newDate = d.toString().replace(" ", "_").replace(":", "_");
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
		String temp = ts.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(temp,testName+newDate);
		test.log(Status.INFO, "==========="+testName+"FAILURE==");
	}
	
	@Override
	public void onTestSkipped(ITestResult result)
	{
		test.log(Status.INFO, result.getMethod().getMethodName()+"SKIPPED====");
	}
	
	
}
