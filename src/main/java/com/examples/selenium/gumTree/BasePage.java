package com.examples.selenium.gumTree;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver = null;
	
	  protected BasePage(WebDriver driver) {
		    this.driver = driver;
		  }

	//	public BasePage(WebDriver driver) {
//
//	}
	  public Object waitUntilVisible(int timeOutInSeconds, WebElement webElement) {
		    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		    wait.until(ExpectedConditions.visibilityOf(webElement));
		    return this;
		  }
}
