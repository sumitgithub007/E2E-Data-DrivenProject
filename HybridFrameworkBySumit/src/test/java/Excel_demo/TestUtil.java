package Excel_demo;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.testng.annotations.DataProvider;
 

public class TestUtil {
 
	
	
	@DataProvider(name="dp")
	public Object[][] Data(Method m) throws IOException
	{
		
	    String sheetname  =	 m.getName();
 		ExcelReader excel = new ExcelReader(sheetname);
		int rowcount =excel.rowcount();
		int columncount =excel.colcount();
		
		Object [][] data = new Object[rowcount][columncount];
		
		for(int i=0;i<rowcount;++i)	
		{
			for(int j=0;j<columncount;++j)
			{
				data[i][j] = excel.getDataSheet(i+1,j);
			}
		
		
		}
		return data;
	}
	
	
	
	
}
