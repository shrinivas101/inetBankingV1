package com.inetBaning.utilities;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Reporting extends TestListenerAdapter {
	
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest logger;
	
	public void onStart() {
		
		String timeStamp = new SimpleDateFormat("yyyy.mm.dd.hh.mm.ss").format(new Date());
		String repName = "Test-Report-"+timeStamp+".html";
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"test-output/"+repName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
		
		extentReports = new ExtentReports();
		
		extentReports.attachReporter(htmlReporter);
		extentReports.setSystemInfo("host name", "localhost");
		extentReports.setSystemInfo("environment", "QA");
		extentReports.setSystemInfo("user", "Shrinivas");
		
		htmlReporter.config().setDocumentTitle("inetBankingProject");
		htmlReporter.config().setReportName("Functioal Test Report");
		/* htmlReporter.config().setTestViewChartLocation(ChartLocation.Top); */
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr) {
		
		logger = extentReports.createTest(tr.getName());
		logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));
	}
	
	public void onTestFailure(ITestResult tr) {
		
		logger = extentReports.createTest(tr.getName());
		logger.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
		
		String screenShotPath = System.getProperty("user.dir")+"screenshots\\"+ tr.getName() + ".png";
		
		File f = new File(screenShotPath);
		
		if(f.exists()) {
			try {
				
				logger.fail("screeenshot below" + logger.addScreenCaptureFromPath(screenShotPath));
			} catch (Exception e) {
				
				e.printStackTrace();
				// TODO: handle exception
			}
		}
	}
	
	public void onTestSkip(ITestResult tr) {
		
		logger = extentReports.createTest(tr.getName());
		logger.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestResult tr) {
		
		extentReports.flush();
	}

}
