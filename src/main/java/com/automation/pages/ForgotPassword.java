package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.TestBase;

public class ForgotPassword extends TestBase{
	WebElement webele;
	
	public String forgetPasswordLinkNavigate() {
		System.out.println("--------Click the Forget Password--------");
		webele = driver.findElement(By.linkText("Forgot Password"));
		click(webele, 5);
		webele = driver.findElement(By.xpath("//*[@id='content']/div/h2"));
		String strTitle = getText(webele,5);
		return strTitle;
	}
	
	public String forgetPassword() {
		System.out.println("--------Forget Password Details--------");
		webele = driver.findElement(By.id("email"));
		sendKey(webele, 5, "sample@gmail.com");
		
		webele = driver.findElement(By.id("form_submit"));
		click(webele, 5);
		
		webele = driver.findElement(By.id("content"));
		String strTitle = getText(webele,5);
		navHome();
		return strTitle;
	}
}
