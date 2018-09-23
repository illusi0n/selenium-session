package com.examples.selenium.cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public class DriverCookieManagerImpl implements DriverCookieManager {

	private FileSystemCookieManager cookieManager;

	public DriverCookieManagerImpl(FileSystemCookieManager cookieManager) {
		this.cookieManager = cookieManager;
	}

	public boolean save(WebDriver driver) {
		Set<Cookie> cookies = driver.manage().getCookies();
		cookieManager.save(cookies, "cookies.txt");
		return true;
	}

	public boolean load(WebDriver driver) {
		Set<Cookie> cookies = cookieManager.load("cookies.txt");
		for (Cookie cookie : cookies)
			driver.manage().addCookie(cookie);
		return true;
	}

}