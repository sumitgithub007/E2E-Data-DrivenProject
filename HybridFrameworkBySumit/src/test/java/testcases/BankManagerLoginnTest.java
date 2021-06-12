package testcases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import basePackage.TestBase;

public class BankManagerLoginnTest extends TestBase {

	
	@Test
	public void LoginAsBankManager() throws InterruptedException, IOException
	{
	
		
	 
		
	 // Thread.sleep(4000);
	 Click("bmlBtn");
      
	 VerifyEquals("abc","xyz");
	  
	 Thread.sleep(4000);
	
	
    driver.findElement(By.xpath(OR.getProperty("addCust"))).click();
	
   
	 
   Assert.fail();
	
	 
	
	}

	
	
	
	
}
