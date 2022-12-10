package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Amazonpage {
	WebDriver driver;
	
	@FindBy(xpath="sdc")
	public static WebElement search;

}
