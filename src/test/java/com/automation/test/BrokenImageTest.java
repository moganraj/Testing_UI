package com.automation.test;

import java.io.IOException;
import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pages.BrokenImage;

public class BrokenImageTest  extends TestBase{

	BrokenImage brokimg;
	
	public BrokenImageTest(){
		super();
	} 
	
	@BeforeClass
	public void setUp() {	//initialization
		initialization();	
		brokimg = new BrokenImage();
	}
	
	@Test(priority=0)
	public void brokenImageLinkNavigateTest() throws MalformedURLException, IOException {
		System.out.println("--------Broken Image Link Navigation Test--------");		
		String strTitle = brokimg.brokenImagelinkNavigate();
		Assert.assertEquals(strTitle, "Broken Images", "Failed: Should navigate to Broken Image link");
	}
	
	@Test(priority=1)
	public void brokenImageTest() throws MalformedURLException, IOException {
		System.out.println("--------Broken image Verification Test--------");		
		Boolean booleanValue = brokimg.verifyBrokenimage();	

		Assert.assertTrue(booleanValue,"Failed: Broken images should be present in the webpage");
	}
	
	@AfterClass
	public void teardown() { //Exit Browser.
		quit();
	}
	
}

