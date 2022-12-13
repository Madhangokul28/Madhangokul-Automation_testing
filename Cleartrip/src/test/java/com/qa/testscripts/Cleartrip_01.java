package com.qa.testscripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.Cleartrip_Element;
import com.qa.utitlity.ExcelUtility;

public class Cleartrip_01 extends TestBase{


	@DataProvider(name="getdata")
	public String[][] getData() throws IOException 
	{
		String xFile="C:\\Users\\madha\\eclipse-workspace\\Cleartrip\\src\\test\\java\\com\\qa\\testdata\\Book1.xlsx";
		String xSheet="Sheet1";

		int rowCount = ExcelUtility.getRowCount(xFile, xSheet);
		int cellCount = ExcelUtility.getCellCount(xFile, xSheet, rowCount);
		System.out.println("rows = "+rowCount);
		System.out.println("cells = "+cellCount);

		String[][] data = new String[rowCount][cellCount];

		for(int i=1; i<=rowCount; i++) 
		{
			for(int j=0;j<cellCount;j++) 
			{
				data[i-1][j] = ExcelUtility.getCellData(xFile, xSheet, i, j);
			}
		}
		return data;
	}

	@Test(dataProvider = "getdata")
	public void getTest(String Source, String Destination ) throws IOException, InterruptedException, AWTException 
	{

		PageFactory.initElements(driver, Cleartrip_Element.class);
		Thread.sleep(6000);

		Robot robot = new Robot(); 

		Cleartrip_Element.Where.click();
		Thread.sleep(2000); 	

		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(2000); 	
		robot.keyRelease(KeyEvent.VK_BACK_SPACE);

		Thread.sleep(8000);
		Cleartrip_Element.Where.sendKeys(Source);
		Thread.sleep(15000);

		//Cleartrip_Element.drop1.click();
		//Thread.sleep(4000);
		
		try {
			Cleartrip_Element.drop1.click();
			Thread.sleep(4000);
			//System.out.println(Cleartrip_Element.flightdetails.getText());
			
		}catch(NoSuchElementException e){
			
			TakesScreenshot scrShot =((TakesScreenshot) driver);
			File firstsrc1=scrShot.getScreenshotAs(OutputType.FILE);
			File destination1= new File("./snapimg/failed1.png");
			FileUtils.copyFile(firstsrc1,destination1);
			System.out.println("failed drop");
			System.out.println("not found the element  ");
			Thread.sleep(4000);
		}

		Cleartrip_Element.to.click();
		Thread.sleep(4000);

		robot.keyPress(KeyEvent.VK_BACK_SPACE);
		Thread.sleep(4000);

		robot.keyRelease(KeyEvent.VK_BACK_SPACE);		
		Thread.sleep(8000);

		Cleartrip_Element.to.sendKeys(Destination);
		Thread.sleep(15000);
		
		try {
			Cleartrip_Element.drop2.click();
			Thread.sleep(4000);
			//System.out.println(Cleartrip_Element.flightdetails.getText());
			
		}catch(NoSuchElementException  e){
			
			TakesScreenshot scrShot =((TakesScreenshot) driver);
			File firstsrc2=scrShot.getScreenshotAs(OutputType.FILE);
			File destination2= new File("./snapimg/failed2.png");
			FileUtils.copyFile(firstsrc2,destination2);
			System.out.println("not found the element 1 ");
			Thread.sleep(4000);

		}
		
		
		//Cleartrip_Element.drop2.click();
		//Thread.sleep(8000);
		Cleartrip_Element.search.click();
		Thread.sleep(16000);

		driver.navigate().back();
		Thread.sleep(8000);

	}


}
