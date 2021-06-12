package utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import basePackage.TestBase;

 

public class TestUtil extends TestBase{

	public static String  screenShotName;
	
	public static void CapTureScreenshot() throws IOException
	{
		Date d = new Date();
		
		
		screenShotName  = d.toString().replace(":","_").replace(" ", "_") + ".png";
		
		File srcfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(srcfile,new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\"+screenShotName));
	}
	
	
	@DataProvider(name="dp")
	public Object[][] getDatamethod(Method m)
	{
		String sheetname=m.getName();
		int rowcount= excel.getRowCount(sheetname);
		int columns = excel.getColumnCount(sheetname);
				 
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
