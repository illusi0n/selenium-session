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

		driver.manage().window().maximize(); 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		LoginPage loginPage= new LoginPage(driver);
		driver.get("http://www.gmail.com");

		Thread.sleep(30000);

		//cookieManager.save(driver);
		Set<Cookie> cookies = driver.manage().getCookies();

		driver.quit();
		WebDriver driver2 = new ChromeDriver();
		driver2.get("http://www.gmail.com");

		driver2.manage().deleteAllCookies();
		
		Thread.sleep(1000);
		cookieManager.load(driver2,cookies);
		driver2.get("http://www.gmail.com");
		Thread.sleep(1000);
		driver2.navigate().refresh();
	}

	public static void openBrowserAndResetCookie() throws InterruptedException {
		System.setProperty(Constants.CHROME_DRIVER_PROPERTY, Constants.CHROME_DRIVER_LOCATION);
		WebDriver driver = new ChromeDriver();

		driver.get("http://www.gmail.com");

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
	
}
