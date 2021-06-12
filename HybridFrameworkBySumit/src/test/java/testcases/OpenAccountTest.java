package testcases;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basePackage.TestBase;
import utilities.TestUtil;

public class OpenAccountTest extends TestBase {

	
	
	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void openAccountTest(String customer,String currency) throws InterruptedException, IOException
	{
		
		Click("openaccount");
		

		select("customer",customer);
		
		select("currency",currency);
		
		
		
		
		Click("process");

		
		Alert alert= wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		System.out.println(customer);
	System.out.println(currency);

    
       
	  
	} 
}
