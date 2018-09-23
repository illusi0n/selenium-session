package com.examples.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.examples.selenium.cookies.*;//DriverCookieManager;
//import com.examples.selenium.cookies.DriverCookieManagerImpl;
//import com.examples.selenium.cookies.FileSystemCookieManagerImpl;
import com.examples.selenium.*;
public class MainApp extends Gmail {

	public MainApp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	static String sEmail="radetesting";
	static String sPass ="Radegejmer1";
	
	public static DriverCookieManager cookieManager = new DriverCookieManagerImpl(new FileSystemCookieManagerImpl());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(Constants.CHROME_DRIVER_PROPERTY, Constants.CHROME_DRIVER_LOCATION);
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.gmail.com");

		Gmail gmail = new Gmail(driver);
		Thread.sleep(20000);

//		if (gmail.isLoginButtonPresent()) {
//		gmail
//		.clickLogin()
//		.typeEmail(sEmail)
//		.clickNext()
//		.typePassword(sPass)
//		.clickNextOnPassword();  }
//		else
//		{
//			gmail.typeEmail(sEmail)
//			.clickNext()
//			.typePassword(sPass)
//			.clickNextOnPassword(); 
//	//	}
		
		
		Thread.sleep(2500);

		cookieManager.save(driver);

		driver.close();

		driver = new ChromeDriver();

		driver.get("http://www.gmail.com");
		cookieManager.load(driver);
		driver.navigate().refresh();

	}

}
