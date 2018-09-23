package com.examples.selenium.cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

public interface DriverCookieManager {
	boolean save(WebDriver driver);
	boolean load(WebDriver driver);
	boolean load(WebDriver driver, Set<Cookie> cookies);
}
