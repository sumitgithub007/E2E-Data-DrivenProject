package Excel_demo;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvidertestEmployee {

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void EmployeeInfo(String empid,String empname,String design)
	{
		System.out.println(empid + " " + empname + " " +design);
	}
	 
	
	
	
	
	
}
