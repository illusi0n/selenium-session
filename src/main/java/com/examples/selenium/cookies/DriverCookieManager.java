package com.examples.selenium.cookies;

import org.openqa.selenium.WebDriver;

public interface DriverCookieManager {
	boolean save(WebDriver driver);
	boolean load(WebDriver driver);
}
