package com.examples.selenium.gumTree;

import com.examples.selenium.Constants;
import java.awt.Insets;
import java.awt.TextField;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	 
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	/**
	 * Locators
	 * */
	
	@FindBy(name="username")
	private WebElement emailLoginLocator;
	
	@FindBy(name="password")
	private WebElement passwordLoginLocator;

	@FindBy (xpath ="//button[contains(text(),'I Accept')]")
	private WebElement acceptCookiesLocator;

	
	    String sEmail = "rade.testing@gmail.com";
	    String sPassword = "Hard1234!@#$";
	    
	    String sInfoMessageRemoveManually = "Please remove anti-bot protection manually";
	    String sTitleBar = "Bot message";

			// go to Login page of GumTree site
			public LoginPage loginGumTree(String sEmail, String sPassword) { 
			System.out.println("Navigating to GumTree website login page");
			driver.get(Constants.GUM_TREE_URL+Constants.LOGIN_URL); 
			
			System.out.println("Entering email");
			waitUntilVisible(5, emailLoginLocator);
			emailLoginLocator.sendKeys(sEmail);
			
			System.out.println("Entering password");
			waitUntilVisible(5, passwordLoginLocator);
			passwordLoginLocator.sendKeys(sPassword);
			}
			
			
			try {
			WebElement acceptButton = driver.findElement(By.xpath(""));
			if (acceptButton.isDisplayed()) {
				acceptButton.click();
				System.out.println("Accepting cookie policy");
			}
			}finally {
				System.out.println("Cookie policy not displayed!");
			}
			
			
			System.out.println("Entering password");
			WebElement passwordInput = driver.findElement(By.name("password"));
			passwordInput.sendKeys(sPassword);
			
			System.out.println("Clicking on Login button");
			WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));
			loginButton.click();
			
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			boolean bAntibot = false;	
			
	     	Thread.sleep(500);

	    		System.out.println("Locating captcha window");
	    		driver.switchTo().frame(driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/iframe[1]")));

	     	Thread.sleep(500);

			 	try 
			 	{
			 		WebElement verifyButton = driver.findElement(By.id("recaptcha-verify-button"));
					if (verifyButton.isDisplayed()) {
					System.out.println("Anti-bot is displayed! Please solve it manually!");
						bAntibot = true;
					} 
			 	} catch (org.openqa.selenium.NoSuchElementException e) 
			 	{
					System.out.println("Verify button not displayed");
			 	}
			 	
				try 
				{
					WebElement skipButton = driver.findElement(By.id("recaptcha-skip-button"));
					if (skipButton.isDisplayed()) 
						{
						System.out.println("Anti-bot is displayed! Please solve it manually!");
						bAntibot = true; 
						} 
				} 
				catch (org.openqa.selenium.NoSuchElementException e) 
				{
					System.out.println("Skip button not displayed");
				}
				
				 do { 
					infoBox(sInfoMessage, sTitleBar);
					Thread.sleep(1000);
					try {
						WebElement status = driver.findElement(By.name("status"));
						if (status.isDisplayed()) {
							bAntibot=false;
						}
					} catch (org.openqa.selenium.NoSuchElementException e) 
					{
						System.out.println("Anti-bot still present, retrying");
					}
				} while (bAntibot == true);
				
				 WebElement postAddButton = driver.findElement(By.xpath("//ul[@class='clearfix']/li[2]/a[@title='Post an ad']"));
				 postAddButton.click();
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//			WebElement elementWait = wait.until(
//			        ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Skip')]")));
//	        System.out.println("Either 'Skip' button is displayed or seconds have timed out");
	        
//			WebElement postAdButton = driver.findElement(By.xpath("//div[@class='txt-center space-maxl']/a[contains(text(),'Post an ad')]"));
//			WebElement manageMyAdds = driver.findElement(By.xpath("//a[@title='Manage my ads']"));

//	        if (skipButton.isDisplayed()) {
//	    		System.out.println("Waiting to manually populate anti-bot protection");
//	  			     
//				WebDriverWait wait2 = new WebDriverWait(driver, 10);
//				WebElement elementWait2 = wait.until(
//				        ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@title='Manage my ads']")));
//		        System.out.println("Either 'Post an Ad' button is displayed or seconds have timed out");
//	        }
			
//			System.out.println("Posting an add (TO BE CONTINUED)");
//			postAdButton.click();

			    
	    
	    public static void infoBox(String sInfoMessage, String sTitleBar){
	        JOptionPane.showMessageDialog(null, sInfoMessage, "InfoBox: " + sTitleBar, JOptionPane.INFORMATION_MESSAGE);
	    }
	}

