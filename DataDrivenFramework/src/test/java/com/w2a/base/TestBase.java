package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;

public class TestBase {

	/*
	 * Webdriver Properties Logs ExtentReports DB Excel Mail
	 */
  //Lifetime of instance variables as long as object stays in memory
	//An instance variable will be accessible as long as some object reference variable contains the address of that object
	public static WebDriver driver;
	public static Properties config = new Properties();
	public  static Properties OR =new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testData.xlsx");
    public static WebDriverWait wait;	
	public static ExtentReports extent= ExtentManager.getInstance();
    public static ExtentTest test;
	
	@BeforeSuite
	public void Setup() throws IOException {
		
		
		if (driver == null) {
		
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\Config.properties");
			config.load(fis);

			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
			OR.load(fis);
			
		}
			if(config.get("browser").equals("chrome")) {
				
				System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver=new ChromeDriver();
				
				
				
			}
			else if(config.get("browser").equals("firefox"))
			{
				System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\geckodriver.exe");
				driver=new FirefoxDriver();
				
			}
				
			driver.get(config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.valueOf(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
		   wait = new WebDriverWait(driver,5);	
		}
		
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null)
		{
		  driver.quit();	
		}
	}
	
	
	public void Click(String locator)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).click();
		test.log(LogStatus.INFO, "clicking on "+locator);
	}
  	
	public void type(String locator,String value)
	{
		driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		test.log(LogStatus.INFO, "Typing in " +locator +" entered value as " + value);
	}
  	
	
	

}
