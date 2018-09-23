package com.examples.selenium.cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;

public interface FileSystemCookieManager {
	boolean save(Set<Cookie> cookies,String filePath);
	Set<Cookie> load(String filePath);
}
