package com.w2a.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.w2a.base.TestBase;

public class BankManagerLoginnTest extends TestBase {

	
	@Test
	public void LoginAsBankManager() throws InterruptedException
	{
	
		
	 
		
	
	 Click("bmlBtn");
      
	
		 Assert.fail("Login failed");
	
	
	
	
    driver.findElement(By.xpath(OR.getProperty("addCust"))).click();
	
   
	 
	
	
	}

	
	
	
	
}
