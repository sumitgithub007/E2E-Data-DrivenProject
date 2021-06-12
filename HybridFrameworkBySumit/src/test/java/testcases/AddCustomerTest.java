package testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.TestBase;
import utilities.TestUtil;

public class AddCustomerTest extends TestBase {

	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void addCustomerTest(String firstName,String lastName,String postCode,String alerttext) throws InterruptedException
	{
		
		 		

       //driver.findElement(By.xpath(OR.getProperty("addCust"))).click();
	 // Click("addCust");
       
       
      // driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
       type("firstname",firstName);
    
       
       //driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
       type("lastname",lastName);
       
       
       Thread.sleep(2000);
      
       
       
       //driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);  
       type("postcode",postCode);
       
       
      Click("addCustomerbtn");
       
		Thread.sleep(3333);
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		Thread.sleep(2333);
       
       
      // driver.findElement(By.xpath(OR.getProperty("addCustomerbtn"))).click();
     
      
       
      
       
	  
	}
	
	 
	
}
