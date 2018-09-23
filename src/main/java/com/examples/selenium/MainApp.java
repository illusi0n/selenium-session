package com.examples.selenium;

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

		Thread.sleep(25000);

		cookieManager.save(driver);

		driver.close();

		driver = new ChromeDriver();

		driver.get("http://www.gmail.com");
		cookieManager.load(driver);
		driver.navigate().refresh();

	}

}
