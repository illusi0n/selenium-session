package com.examples.selenium.cookies;

import java.util.Date;
import java.util.Set;

import org.openqa.selenium.Cookie;

public class CookieConvertor {

	/**
	 * Convert cookie to string to a following format
	 * name,value,expires,domain,path,isSecure,isHttpOnly
	 * 
	 * @param cookie
	 * @return
	 */
	public static String convertToString(Cookie cookie) {
		StringBuilder cookieAsString = new StringBuilder();
		cookieAsString.append(cookie.getName() + ",");
		cookieAsString.append(cookie.getValue() + ",");
		cookieAsString.append(cookie.getDomain() + ",");
		cookieAsString.append(cookie.getPath() + ",");
		if (cookie.getExpiry() != null)
			cookieAsString.append(cookie.getExpiry().getTime() + ",");
		else
			cookieAsString.append("MISSING" + ",");
		cookieAsString.append(cookie.isSecure() + ",");
		cookieAsString.append(cookie.isHttpOnly());
		return cookieAsString.toString();
	}

	public static String convertToString(Set<Cookie> cookies) {
		StringBuilder cookiesAsString = new StringBuilder();
		for (Cookie cookie : cookies) {
			cookiesAsString.append(convertToString(cookie) + '\n'); // put system line end operator
		}
		return cookiesAsString.toString();
	}

	public static Cookie convertToCookie(String cookie) {
		String[] cookieElements = cookie.split(",");
		String name = cookieElements[0];
		String value = cookieElements[1];
		String domain = cookieElements[2];
		String path = cookieElements[3];
		Date expire = null;
		if (!cookieElements[4].equals("MISSING")) {
			expire = new Date(Long.valueOf(cookieElements[4]));
		}
		boolean isSecure = Boolean.valueOf(cookieElements[5]);
		boolean isHttpOnly = Boolean.valueOf(cookieElements[6]);
		return new Cookie(name, value, domain, path, expire, isSecure, isHttpOnly);
	}
}
