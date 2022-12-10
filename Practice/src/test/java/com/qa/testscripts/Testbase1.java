package com.qa.testscripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Testbase1 {
	WebDriver driver;

	@Parameters({"Browser","Url"})
	@BeforeClass
	public void Test(String Browser,String Url) {
	if(Browser.equalsIgnoreCase("Chrome")) {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}else if(Browser.equalsIgnoreCase("Edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new ChromeDriver();
		
	}
	driver.manage().window().maximize();
	driver.get(Url);
	
	
	

}
	@AfterClass
	public void Teardown() throws InterruptedException {
		Thread.sleep(4000);
		driver.quit();
		
	}

	}
