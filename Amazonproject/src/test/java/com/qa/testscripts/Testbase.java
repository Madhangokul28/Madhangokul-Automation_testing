package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase {
	
		WebDriver driver;

		@Parameters({"Browser","Url"})
		@BeforeClass
		public void browser(String browser,String url){

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
		}


		@AfterClass
		public void close() throws InterruptedException {
		
			Thread.sleep(2000);
			driver.quit();
		}	
	}
