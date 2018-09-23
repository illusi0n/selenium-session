package com.examples.selenium;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.examples.selenium.cookies.DriverCookieManager;
import com.examples.selenium.cookies.DriverCookieManagerImpl;
import com.examples.selenium.cookies.FileSystemCookieManagerImpl;

public class MainApp {

	public static DriverCookieManager cookieManager = new DriverCookieManagerImpl(new FileSystemCookieManagerImpl());

	public static void main(String[] args) throws InterruptedException {
		System.setProperty(Constants.CHROME_DRIVER_PROPERTY, Constants.CHROME_DRIVER_LOCATION);
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.gmail.com");

		Thread.sleep(30000);

		//cookieManager.save(driver);
		Set<Cookie> cookies = driver.manage().getCookies();
		
		driver.close();

		driver = new ChromeDriver();

		driver.get("http://www.gmail.com");
		driver.manage().deleteAllCookies();
		
		Thread.sleep(10000);
		//cookieManager.load(driver);
		cookieManager.load(driver, cookies);
		driver.navigate().refresh();
	}

}
