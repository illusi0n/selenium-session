package com.examples.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail {
	
	WebDriver driver;
	

	
	//	public Gmail(WebDriver driver) {
//		super(driver);
//	}
	  public Gmail(WebDriver driver) {
		  System.out.println("Start Gmail App");
		   // super(driver);
	//	    log.debug("new ManagePage()");
		  }

	@FindBy(className="gmail-nav__nav-link gmail-nav__nav-link__sign-in")
	private WebElement gmailLoginLocator;
	
	@FindBy(xpath= "//input[@id='identifierId']")
	private WebElement emailInputLocator;
	
	@FindBy(id= "identifierNext")
	private WebElement nextEmailButtonLocator;

	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordLocator;
	
	@FindBy(id= "passwordNext")
	private WebElement nextPasswordButtonLocator;
	
	
	public Object waitUntilVisible(int timeOutInSeconds, WebElement webElement) {
	    WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	    wait.until(ExpectedConditions.visibilityOf(webElement));
	    return this;
	}
	  
	public Gmail clickLogin() {
		System.out.println("Click login button");
		waitUntilVisible(10,gmailLoginLocator);
		gmailLoginLocator.click();
		return this;
	}
	
	public Gmail typeEmail(String email) {
		System.out.println("Type email");
		//waitUntilVisible(10,emailInputLocator);
		emailInputLocator.sendKeys(email);
		return this;
	}

	public Gmail clickNext() {
		System.out.println("click Next button");
		waitUntilVisible(10,nextEmailButtonLocator);
		nextEmailButtonLocator.click();
		return this;
	}
	
	public Gmail typePassword(String password) {
		System.out.println("Type password");
		waitUntilVisible(10,passwordLocator);
		passwordLocator.sendKeys(password);
		return this;
	}
	
	public Gmail clickNextOnPassword() {
		System.out.println("click Next button");
		waitUntilVisible(10,nextPasswordButtonLocator);
		nextPasswordButtonLocator.click();
		return this;
	}
	
	public boolean isLoginButtonPresent() {
		System.out.println("isLoginButtonPresent");
		return gmailLoginLocator.isDisplayed();
	}
}
