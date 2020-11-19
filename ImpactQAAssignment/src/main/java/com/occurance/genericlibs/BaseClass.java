package com.occurance.genericlibs;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.occurance.dataUtils.Constants;
import com.occurance.frameworkutils.TakeScreenShot;

import org.testng.annotations.BeforeClass;

public class BaseClass implements Constants{
	public static WebDriver driver;
	
	@BeforeSuite
	public void configBS() {
		
	}
	@BeforeClass
	public void configBC() {
		driver = new ChromeDriver();
		
	}
	@BeforeMethod
	public void configBM() {
		driver.get(".\\Occurance\\Assignment.html");
	}
	
	@AfterMethod
	public void configAM(ITestResult res) throws IOException {
		
		int status = res.getStatus();
		String name = res.getName();
		/*Get screenshot for both conditions */
		if(status==ITestResult.FAILURE) {
		new TakeScreenShot().getScreenshot(driver, "./screenshots/"+name+".png");
		}
	}
	
	@AfterClass
	public void configAC() {
		driver.close();
	}
	@AfterSuite
	public void configAS() {
		
	}
}
