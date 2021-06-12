package Excel_demo;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvideeLoginTestCase {

	@Test(dataProviderClass=TestUtil.class,dataProvider="dp")
	public void LoginDetails(String loginid,String username)
	{
		System.out.println(loginid + " " + username);
	}
	
	
	
	
}
