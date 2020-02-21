package com.automation.pages;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.TestBase;

public class BrokenImage extends TestBase {

	public String brokenImagelinkNavigate() {
		System.out.println("--------Click the Broken Images--------");
		WebElement webele = driver.findElement(By.linkText("Broken Images"));
		click(webele, 5);
		String strTitle = driver.findElement(By.xpath("//*[@id='content']/div/h3")).getText();
		return strTitle;
	}
	
	public Boolean verifyBrokenimage() throws MalformedURLException, IOException {
		
		System.out.println("--------Verify the Broken Images--------");
		Boolean booleanVal = false;
		List<WebElement> lst = driver.findElements(By.tagName("img"));	//Get the all the image tag 
		List<WebElement> activelst = new ArrayList<WebElement>();	//Declaration for Active images
		
		for(int i =0;i<lst.size();i++) {
			//System.out.println(lst.get(i).getAttribute("src"));
			if(lst.get(i).getAttribute("src")!=null) {	//Remove all the img tags that does not have src
				activelst.add(lst.get(i));
			}
		}
		
		for(int i =0; i<activelst.size(); i++) { //Verify the image is working fine or its having broken link
			HttpURLConnection connection = (HttpURLConnection) new URL(activelst.get(i).getAttribute("src")).openConnection();
			connection.connect();
			String strResponse = connection.getResponseMessage();
			connection.disconnect();
			System.out.println(strResponse);
			if(!strResponse.equals("OK")) {
				booleanVal=true;
				break;
			}
		}
		return booleanVal;
	}
	
	
}
