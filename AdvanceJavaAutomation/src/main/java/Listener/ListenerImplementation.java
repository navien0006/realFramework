package Listener;

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

import Config.BaseClass;

public class ListenerImplementation implements ITestListener, ISuiteListener {
	ExtentReports report;
	ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		Reporter.log("execution started",true);
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+" execution started");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		Reporter.log("executed successfully",true);
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.PASS, result.getMethod().getMethodName()+" execution completed successfully");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testcasename = result.getMethod().getMethodName();
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getMethod().getMethodName()+" execution faild");
		Date d=new Date();
		String dateformat = d.toString().replace(" ", "_").replace(":", "_");
		TakesScreenshot ss=(TakesScreenshot)BaseClass.sdriver;
		String file = ss.getScreenshotAs(OutputType.BASE64);
		test.addScreenCaptureFromBase64String(file,testcasename+dateformat);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		Reporter.log("execution skipped",true);
		test=report.createTest(result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getMethod().getMethodName()+" execution skiped");
	}

	@Override
	public void onStart(ISuite suite) {
		Date d =new Date();
		String newdate = d.toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/ninzacrm"+newdate+".html");
		spark.config().setDocumentTitle("Reports");
		spark.config().setReportName("CRMNinza");
		spark.config().setTheme(Theme.DARK);
		
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("os", "windows");
		report.setSystemInfo("browser", "chrome");
		
	}

	@Override
	public void onFinish(ISuite suite) {
		report.flush();
		
	}

	
}
