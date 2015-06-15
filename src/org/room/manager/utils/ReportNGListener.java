package org.room.manager.utils;

import org.apache.commons.io.FileUtils;
import org.room.manager.managerPage;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import java.io.File;
import java.io.IOException;
import org.room.manager.utils.configReader;;
public class ReportNGListener implements ITestListener{
	Logger log = Logger.getLogger(getClass());
	private static WebDriver driver= managerPage.getManager().getBrowserChrome();
	//String filePath = "D:\\MOnitor\\Monitor4\\RoomManagerAutomation\\RoomManagerAutomation\\screenshots";
	@Override
	public void onStart(ITestContext result) {
		PropertyConfigurator.configure("log4j.properties");
		log.info("Start Of Execution(TEST)-> " + result.getName());
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		log.info("Test Started-> " + result.getName());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		log.info("Test Passed-> " + result.getName());
	}
	
	@Override
	public void onTestFailure(ITestResult result) {
		try {
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			String filePath = System.getProperty("user.dir") + "/screenshots/";
			String failureImageFileName;
			if(result.getMethod().toString().contains("java.lang")) {	
				failureImageFileName =  result.getName() + "_" + result.getParameters()[0] + ".png"; 
			} else { 
				failureImageFileName =  result.getName() + ".png"; 
			}
			//Taking the screenshot
			takeScreenShot(filePath, failureImageFileName);	
			Reporter.log("<a href=\"" + filePath + failureImageFileName 
					+ "\"><img src=\"file:///" + filePath + failureImageFileName 
					+ "\" alt=\"\"" + "height='100' width='100'/> " + "<br />"); 
			Reporter.setCurrentTestResult(null);
			} catch (IOException e) {
				e.printStackTrace();
			}
			log.error("Test Failed-> " + result.getName());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		log.warn("Test Skipped-> " + result.getName());
	}	
	@Override
	public void onFinish(ITestContext context) {
		log.info("END Of Execution(TEST)-> " + context.getName());
	}
	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		log.info("Success percentage failure -> " + result.toString());	
	}
	/** 
	 * This method takes screenshots 
	 * @param filePath 
	 * @param fileName 
	 * @throws IOException 
	 */ 
	public static void takeScreenShot(String filePath, String fileName) throws IOException {
		try { 
			File scrFile = ((TakesScreenshot)managerPage.getManager().getBrowserChrome())
					.getScreenshotAs(OutputType.FILE); 
			FileUtils.copyFile(scrFile, new File(filePath + fileName)); 
		} catch (Exception e) { 
			e.printStackTrace(); 
		}  
	} 
}