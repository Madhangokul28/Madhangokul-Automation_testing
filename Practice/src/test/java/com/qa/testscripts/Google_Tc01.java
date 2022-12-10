package com.qa.testscripts;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.qa.pages.GoogleSearch;

public class Google_Tc01 extends Testbase1{
	   GoogleSearch  element;
	   @Parameters({"Browser","Url"})
	   @Test
		public void google(String Browser, String Url) throws InterruptedException {
		PageFactory.initElements(driver, GoogleSearch.class);
		Thread.sleep(5000);
		GoogleSearch.search.sendKeys("selenium");
		Thread.sleep(5000);
		System.out.println(GoogleSearch.drop.getText());
		Thread.sleep(5000);	
	}
	

}
