package com.qa.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Amazon_Element 
{

	WebDriver driver;
	@FindBy(id="twotabsearchtextbox")
	public static WebElement Searchbox;

	@FindBy(id="nav-search-submit-button")
	public static WebElement Searchbutton;

	@FindBy(xpath="//*[@id=\"searchDropdownBox\"]")
	public static WebElement category;

	@FindBy(xpath="//span[@class=\"a-size-medium a-color-base a-text-normal\"]")
	public static List<WebElement> result;

}
