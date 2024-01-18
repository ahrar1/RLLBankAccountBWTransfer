package Analyzer;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import pages.TestBase;

public class itestlistner extends  TestBase implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test method starts");
	}
		

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test method sucees");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test method fail");
		System.out.println("Test case failed");
		
		//File srcFile = ((TakesScreenshot)BaseClass.driver).getScreenshotAs(OutputType.FILE);
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test method skipped");
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test method starts");
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("Test method start");
		}
	

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("Test method finmifs");
		
	}

}
