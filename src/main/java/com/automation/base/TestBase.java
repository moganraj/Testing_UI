package com.automation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public TestBase() {
		//Constructor to load the property file
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("src/main/java/com/automation/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			//ChromeOptions and DesiredCapabilities for the chrome driver.
			ChromeOptions options = new ChromeOptions();
			options.setAcceptInsecureCerts(true);
			options.addArguments("disable-infobars");
			DesiredCapabilities ds = new DesiredCapabilities();
			ds.setCapability("something", true);
			options.merge(ds);
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Long.parseLong(prop.getProperty("PAGE_LOAD_TIMEOUT")),TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("IMPLICIT_WAIT")),TimeUnit.SECONDS);

		driver.get(prop.getProperty("url_UI"));

	}
	
	public void navHome() {
		driver.navigate().to(prop.getProperty("url_UI"));
	}

	public static void quit() {
		driver.quit();
	}
	
	//Below all the methods are explicit wait
	
	@SuppressWarnings("deprecation")
	public String getText(WebElement webele, long timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(webele));
		return webele.getText();
	}

	@SuppressWarnings("deprecation")
	public void sendKey(WebElement webele, long timeOut, String strVal) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(webele));
		webele.sendKeys(strVal);
	}

	@SuppressWarnings("deprecation")
	public void click(WebElement webele, long timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(webele));
		webele.click();
	}

	@SuppressWarnings("deprecation")
	public void clickable(WebElement webele, long timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.elementToBeClickable(webele));
		webele.isEnabled();
	}

	@SuppressWarnings("deprecation")
	public Boolean isEnable(WebElement webele, long timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(webele));
		return webele.isEnabled();
	}

	@SuppressWarnings("deprecation")
	public Boolean isDisplay(WebElement webele, long timeOut) {
		new WebDriverWait(driver, timeOut).until(ExpectedConditions.visibilityOf(webele));
		return webele.isDisplayed();
	}


}
