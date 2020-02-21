package com.automation.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.automation.base.TestBase;
import com.automation.pages.DynamicControls;

public class DynamicControlsTest extends TestBase {

	DynamicControls dynamiccntrl;
	
	public DynamicControlsTest() {
		super();
	}

	@BeforeClass
	public void setUp() {
		initialization();
		dynamiccntrl = new DynamicControls();
	}

	@Test(priority = 0)
	public void dynamicControlsLinkNavigateTest() {
		System.out.println("--------Dynamic Controls Link Navigate Test--------");
		String strTitle = dynamiccntrl.dynamicControlsLinkNavigate();
		Assert.assertEquals(strTitle, "Dynamic Controls","Failed: Should navigate to Dynamic control");
	}

	@Test(priority = 1)
	public void dynamicControlsValidationAddRemoveTest() throws InterruptedException {
		System.out.println("--------Dynamic Controls Enable Test--------");
		SoftAssert softAssert1 = new SoftAssert();

		Boolean strChk = dynamiccntrl.dynamicControlsChkBoxValidation();
		softAssert1.assertEquals(strChk, Boolean.TRUE, "Failed: Checkbox should be available");
		System.out.println("CheckBox Validation : " + strChk);

		String strVal = dynamiccntrl.dynamicControlsAddRemoveButtonValidation();
		softAssert1.assertEquals(strVal, "Remove", "Failed: Button should have Remove Lable");
		System.out.println(strVal);

		strVal = dynamiccntrl.dynamicControlsAddRemoveMessageValidation();
		softAssert1.assertEquals(strVal, "It's gone!", "Failed: Expected message should be |It's gone!|");
		System.out.println(strVal);

		strVal = dynamiccntrl.dynamicControlsAddRemoveButtonValidation();
		softAssert1.assertEquals(strVal, "Add", "Failed: Button should have Add Lable");
		System.out.println(strVal);

		strVal = dynamiccntrl.dynamicControlsAddRemoveMessageValidation();
		softAssert1.assertEquals(strVal, "It's back!", "Failed: Expected message should be |It's back!|");
		System.out.println(strVal);

		strChk = dynamiccntrl.dynamicControlsChkBoxBackValidation();
		softAssert1.assertEquals(strChk, Boolean.TRUE, "Failed: Checkbox should be available");
		System.out.println(strChk);

		softAssert1.assertAll();
	}

	@Test(priority = 2)
	public void dynamicControlsValidationEnableDisableTest() {
		System.out.println("--------Dynamic Controls Enable Test--------");
		SoftAssert softAssert2 = new SoftAssert();

		Boolean strChk = dynamiccntrl.dynamicControlsTextBoxValidation();
		softAssert2.assertEquals(strChk, Boolean.FALSE, "Failed: Textbox should be disabled");
		System.out.println("TextBox Validation : " + strChk);

		String strVal = dynamiccntrl.dynamicControlsButtonValidation();
		softAssert2.assertEquals(strVal, "Enable", "Failed: Button should have label Enable");
		System.out.println("Button label Validation : " + strVal);

		strVal = dynamiccntrl.dynamicControlsEnableDisableValidation();
		softAssert2.assertEquals(strVal, "Disable", "Failed: Button should have label Disable");
		System.out.println("Button label Validation" + strVal);

		strVal = dynamiccntrl.dynamicControlsMessageValidation();
		softAssert2.assertEquals(strVal, "It's enabled!", "Failed: Expected message should be |It's enabled!|");
		System.out.println("MessageValidation : " + strVal);

		strChk = dynamiccntrl.dynamicControlsTextBoxValidation();
		softAssert2.assertEquals(strChk, Boolean.TRUE, "Failed: Textbox should be enabled");
		System.out.println("TextBox Validation : " + strChk);

		softAssert2.assertAll();
	}

	@AfterClass
	public void teardown() {
		quit();
	}
}
