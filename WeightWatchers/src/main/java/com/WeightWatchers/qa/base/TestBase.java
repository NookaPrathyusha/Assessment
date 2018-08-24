package com.WeightWatchers.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static String search;
	
	public TestBase()
	{
		//Reading from property file and
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	// setting up initial values 
	public static void initialization()
	{
		//Get the browser details and initiate driver
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")){
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\drivers\\chromedriver.exe");
			driver = new ChromeDriver(); 
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Get URL
		driver.get(prop.getProperty("url"));
		//Get Search text
		search=prop.getProperty("search");
	}
		
	//To wait until text present
	public static void waitUnitlTextPresent(final WebElement element)
	{
		(new WebDriverWait(driver, 20)).until(new ExpectedCondition<Boolean>() {
	     public Boolean apply(WebDriver d) {
	     return element.getText().length() != 0;
	      }
	      });
	}
	
}
