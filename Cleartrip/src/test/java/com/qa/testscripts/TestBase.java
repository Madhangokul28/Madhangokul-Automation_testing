package com.qa.testscripts;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


import io.github.bonigarcia.wdm.WebDriverManager;
public class TestBase {

	WebDriver driver=null;

	@Parameters({"Browser","Url"})
	@BeforeClass
	public void browser(String browser,String url) throws IOException, InterruptedException {

		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")) 
		{
			System.setProperty("webdriver.edge.driver","D:\\Virtusa\\driver\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();		
		}
		else{
			System.out.println("Please Enter the browser Name");

		}
		driver.manage().window().maximize();
		driver.get(url);
		Thread.sleep(6000);
		// close the pop up alert
		driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div/div[1]/div[2]")).click();
	
	}


	@AfterClass
	public void close() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}	
}

