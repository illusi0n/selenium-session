package com.examples.selenium;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.examples.selenium.cookies.DriverCookieManager;
import com.examples.selenium.cookies.DriverCookieManagerImpl;
import com.examples.selenium.cookies.FileSystemCookieManagerImpl;
import com.examples.selenium.gumTree.LoginPage;

public class MainApp extends LoginPage {

	public MainApp(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public static DriverCookieManager cookieManager = new DriverCookieManagerImpl(new FileSystemCookieManagerImpl());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(Constants.CHROME_DRIVER_PROPERTY, Constants.CHROME_DRIVER_LOCATION);
		
		WebDriver driver = new ChromeDriver();

    Thread.sleep(234);
		driver.manage().window().maximize(); 
		Thread.sleep(459);
		
    String sEmail = "rade.testing@gmail.com";
    String sPassword = "Hard1234!@#$";
    
    LoginPage loginPage = new LoginPage(driver).loginGumTree(sEmail, sPassword);

    loginPage.waitUntilCaptchaRemoved();
    
    Thread.sleep(2000);
		//cookieManager.save(driver);
		Set<Cookie> cookies = driver.manage().getCookies();

		driver.quit();
		WebDriver driver2 = new ChromeDriver();
		
    LoginPage loginPage2 = new LoginPage(driver2).loginGumTree(sEmail, sPassword);

		driver2.manage().deleteAllCookies();
		
		Thread.sleep(1000);
		cookieManager.load(driver2,cookies);
		Thread.sleep(1000);
		driver2.navigate().refresh();
	}
/*
	public static void openBrowserAndResetCookie() throws InterruptedException {
		System.setProperty(Constants.CHROME_DRIVER_PROPERTY, Constants.CHROME_DRIVER_LOCATION);
		WebDriver driver = new ChromeDriver();

		//LoginPage loginPage = new LoginPage(driver).loginGumTree(sEmail, sPassword);
		Thread.sleep(30000);

		//cookieManager.save(driver);
		Set<Cookie> cookies = driver.manage().getCookies();


		driver.manage().deleteAllCookies();
		driver.navigate().refresh();
		
		Thread.sleep(10000);
		//cookieManager.load(driver);
		for (Cookie cookie : cookies)
			driver.manage().addCookie(cookie);
		driver.navigate().refresh();
	}
	*/
}
