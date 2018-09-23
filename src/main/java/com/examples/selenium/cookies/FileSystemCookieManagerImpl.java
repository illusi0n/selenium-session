package com.examples.selenium.cookies;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.openqa.selenium.Cookie;

import com.google.common.io.Files;

public class FileSystemCookieManagerImpl implements FileSystemCookieManager {

	public boolean save(Set<Cookie> cookies, String filePath) {
		Writer writer = null;
		String convertedCookies = CookieConvertor.convertToString(cookies);
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"));
			writer.write(convertedCookies);
		} catch (IOException ex) {
			// Report
		} finally {
			try {
				writer.close();
			} catch (Exception ex) {
				/* ignore */}
		}
		return false;
	}

	public Set<Cookie> load(String filePath) {
		Set<Cookie> cookies = new HashSet<Cookie>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line = reader.readLine();
			while (line != null) {
				cookies.add(CookieConvertor.convertToCookie(line));
				line = reader.readLine();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cookies;
	}

}
