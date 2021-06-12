package basePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.ExcelReader;
import utilities.ExtentManager;
import utilities.TestUtil;

public class TestBase {

	/*
	 * Webdriver Properties Logs ExtentReports DB Excel Mail
	 */
    //Last batch Framework
	public static WebDriver driver;
	public static Properties config = new Properties();
	public  static Properties OR =new Properties();
	public static FileInputStream fis;
	public static ExcelReader excel= new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\excel\\testData.xlsx");
    public static WebDriverWait wait;	
	public static ExtentReports extent= ExtentManager.getInstance();
    public static ExtentTest test;
    public static WebElement dropdown;
    
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
				
				System.setProperty("webdriver.chrome.driver","C:\\Users\\sumit goyal\\Downloads\\chromedriver_win32\\chromedriver.exe");
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
	
	
	public static void VerifyEquals(String actual,String expected) throws IOException
	{
		try
		{
			Assert.assertEquals(actual, expected);
		}
		catch(Throwable t)
		{
			TestUtil.CapTureScreenshot();
			 test.log(LogStatus.FAIL,"verification Fail with exception" + t.getMessage()) ;
			 test.log(LogStatus.FAIL,test.addScreenCapture(TestUtil.screenShotName)) ;
			 System.out.println("h");
		
		}
	}
	
	
	public static void select(String locator,String value) throws IOException
	{
		 
		
		dropdown = driver.findElement(By.xpath(OR.getProperty(locator)));
		
		Select s = new Select(dropdown);
		
		
		s.selectByVisibleText(value);
		
		
		test.log(LogStatus.INFO, "Selecting from dropdown " +locator +"  value as " + value);

		
		
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
