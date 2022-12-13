package com.qa.testscripts;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pages.Amazon_Element;
import com.qa.utility.ExcelUtility;


public class Tc_Amazon01 extends Testbase{
	Amazon_Element element;

	@DataProvider(name="getdata")
	public String[][] getData() throws IOException 
	{
		String xFile="C:\\Users\\madha\\eclipse-workspace\\Amazonproject\\src\\test\\java\\com\\qa\\testdata\\Book1.xlsx";
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

	//@Parameters({"Browser","Url"})
	@Test(dataProvider = "getdata")
	public void  Amazon_Search(String categories,String input) throws IOException, InterruptedException, AWTException 
	{

		PageFactory.initElements(driver, Amazon_Element.class);
		Thread.sleep(4000);

		Select slct=new Select(Amazon_Element.category);
		Thread.sleep(5000);
		slct.selectByVisibleText(categories);
		Thread.sleep(4000);

		Amazon_Element.Searchbox.sendKeys(input);
		Thread.sleep(4000);
		Amazon_Element.Searchbutton.click();
		Thread.sleep(4000);
		System.out.println("------------------------------"+input+"----------------------------------"); 
		for(WebElement s: Amazon_Element.result)
		{
			System.out.println(s.getText());
			System.out.println("---------------------------------------------------------------------------");

		}
		Thread.sleep(4000);
		driver.navigate().back();
		Thread.sleep(4000);

	}
}
