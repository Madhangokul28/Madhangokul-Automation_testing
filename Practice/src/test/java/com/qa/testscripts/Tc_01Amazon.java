package com.qa.testscripts;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.pages.Amazonpage;

public class Tc_01Amazon extends Testbase1{
	
	Amazonpage element;
	@Parameters({"Browser","Url"})
	@Test
	public void Scoll(String Browser,String Url) throws InterruptedException, IOException{
		PageFactory.initElements(driver, Amazonpage.class);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,3250)");
		Thread.sleep(3000);
		// method use to take screenshot
		TakesScreenshot scrShot =((TakesScreenshot) driver);
		File firstsrc=scrShot.getScreenshotAs(OutputType.FILE);
		File destination= new File("./snap/scoll.png");
		FileUtils.copyFile(firstsrc,destination);
		js.executeScript("window.scrollBy(0,-3250)");
		File src=scrShot.getScreenshotAs(OutputType.FILE);
		File destination1= new File("./snap/scollup.png");
		FileUtils.copyFile(src,destination1);
		Thread.sleep(3000);


		
		
	}
	
	
	

}
