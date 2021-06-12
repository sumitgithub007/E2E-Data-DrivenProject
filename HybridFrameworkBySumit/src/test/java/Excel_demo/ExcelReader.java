package Excel_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
	public String sheetname;
	public FileInputStream fis=null;
	public FileOutputStream fileOut=null;
	public XSSFWorkbook xssf=null;
	public XSSFSheet sheet=null;
	public Row row=null;
	public XSSFCell cell=null;
	public int rowcount;
	
	public ExcelReader(String sheetName) throws IOException 
	{ 
		sheetname=sheetName;
		
	 fis = new FileInputStream("C:\\Users\\sumit goyal\\Desktop\\Writesheet.xlsx");
	 xssf = new XSSFWorkbook(fis);
 
	
	 sheet = xssf.getSheet(sheetname);
	
	}
	
	public int rowcount()
	{
	     rowcount = sheet.getLastRowNum();
		 System.out.println("total rows are"+rowcount);
		return rowcount;
	}
	
	public int colcount()
	{
		row = sheet.getRow(0);
		  int colcount = row.getLastCellNum();
		  System.out.println("total columns are"+colcount);
		 return colcount;
	}
	 
	public String getDataSheet(int i,int j)
	{
		
		String data1 =sheet.getRow(i).getCell(j).getStringCellValue();

		return data1;
	 
	}
	
 
	
	
	
}