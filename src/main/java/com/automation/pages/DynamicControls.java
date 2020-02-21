package com.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.automation.base.TestBase;

public class DynamicControls extends TestBase {
	WebElement webele;

	public String dynamicControlsLinkNavigate() {
		System.out.println("--------Click the Dynamic Controls page navigation--------");
		webele = driver.findElement(By.linkText("Dynamic Controls"));
		click(webele, 5);
		webele = driver.findElement(By.xpath("//*[@id='content']/div[1]/h4[1]"));
		String strTitle = getText(webele, 5);
		return strTitle;
	}
	
	public Boolean dynamicControlsChkBoxValidation() {
		System.out.println("--------Validation the Checkbox--------");

		webele = driver.findElement(By.xpath("//*[@id='checkbox']/input"));
		return isDisplay(webele, 10);
	}

	public String dynamicControlsAddRemoveButtonValidation() {
		System.out.println("--------Validation of Remove Button--------");
		webele = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
		clickable(webele, 30);
		click(webele, 30);
		String strVal = getText(webele, 10);
		
		return strVal;
	}

	public String dynamicControlsAddRemoveMessageValidation() throws InterruptedException {
		System.out.println("--------Validation of Remove Message--------");
		webele = driver.findElement(By.xpath("//*[@id='checkbox-example']/button"));
		clickable(webele, 30);
		webele = driver.findElement(By.xpath("//*[@id='checkbox-example']/p"));
		String strVal = getText(webele,30);

		return strVal;
	}

	public Boolean dynamicControlsChkBoxBackValidation() {
		System.out.println("--------Validation of Add Checkbox--------");

		webele = driver.findElement(By.xpath("//*[@id='checkbox-example']/div/input"));
		return isDisplay(webele, 10);
	}

	public Boolean dynamicControlsTextBoxValidation() {
		System.out.println("--------Validation of Disable Textbox--------");
		webele = driver.findElement(By.xpath("//*[@id='input-example']/input"));
		return isEnable(webele, 10);
	}

	public String dynamicControlsButtonValidation() {
		System.out.println("--------Validation of Enable Button--------");
		webele = driver.findElement(By.xpath("//*[@id='input-example']/button"));
		String strVal = getText(webele, 10);

		return strVal;
	}

	public String dynamicControlsEnableDisableValidation() {
		System.out.println("--------Validation of Enable action--------");

		webele = driver.findElement(By.xpath("//*[@id='input-example']/button"));
		click(webele, 10);
		clickable(webele, 10);
		String strVal = getText(webele, 10);
		return strVal;
	}

	public String dynamicControlsMessageValidation() {
		System.out.println("--------Validation of Enable/Disable Message--------");
		webele = driver.findElement(By.xpath("//*[@id='input-example']/p"));
		String strVal = getText(webele, 10);

		return strVal;
	}

}
