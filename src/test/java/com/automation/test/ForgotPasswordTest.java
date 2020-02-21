package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.base.TestBase;
import com.automation.pages.ForgotPassword;

public class ForgotPasswordTest  extends TestBase{
	
	ForgotPassword forgotpwd;
	
	public ForgotPasswordTest(){
		super();
	}
	
	@BeforeClass
	public void setUp() {	//initialization
		initialization();
		forgotpwd = new ForgotPassword();
	}
	
	@Test(priority=0)
	public void forgetPasswordLinkNavigateTest() {
		System.out.println("--------Forget Password Link Navigation Test--------");
		String strTitle = forgotpwd.forgetPasswordLinkNavigate();
		Assert.assertEquals(strTitle, "Forgot Password","Failed: Should be Navigated to Forget Password Page");
	}
	
	@Test(priority=1)
	public void forgetPasswordTest() {
		System.out.println("--------Forget Password Verification Test--------");
		String strTitle = forgotpwd.forgetPassword();
		Assert.assertTrue(strTitle.contains("Your e-mail's been sent!"),"Failed: Should have the message displayed 'Your e-mail's been sent!'");
	}
	
	@AfterClass
	public void teardown() { //Exit browser
		quit();
	}
	
	
}
