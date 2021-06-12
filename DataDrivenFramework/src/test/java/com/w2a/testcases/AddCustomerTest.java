package com.w2a.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class AddCustomerTest extends TestBase {

	
	
	@Test(dataProvider="getData")
	public void getData(String firstName,String lastName,String postCode,String alerttext) throws InterruptedException
	{
		
		 		

       //driver.findElement(By.xpath(OR.getProperty("addCust"))).click();
	  Click("addCust");
       
       
      // driver.findElement(By.xpath(OR.getProperty("firstname"))).sendKeys(firstName);
       type("firstname",firstName);
    
       
       //driver.findElement(By.xpath(OR.getProperty("lastname"))).sendKeys(lastName);
       type("lastname",lastName);
       
       
       Thread.sleep(2000);
      
       
       
       //driver.findElement(By.xpath(OR.getProperty("postcode"))).sendKeys(postCode);  
       type("postcode",postCode);
       
       
       Click("addCustomerbtn");
       
       
       Assert.fail("Login failed");
       
      // driver.findElement(By.xpath(OR.getProperty("addCustomerbtn"))).click();
     
      
       
      
       
	  
	}
	
	@DataProvider(name="getData")
	public Object[][] getDatamethod()
	{
		int rowcount= excel.getRowCount();
		int columns = excel.getColumnCount();
				 
		Object [][] data = new Object[rowcount-1][columns];
		
		for(int i=0;i<rowcount-1;++i)	
		{
			for(int j=0;j<columns;++j)
			{
				data[i][j] = excel.getcellData(i, j);
			}
		
		
		}
		return data;
	}
	
}
