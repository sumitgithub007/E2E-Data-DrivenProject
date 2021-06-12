package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	
	public String path;
	public FileInputStream fis=null;
	 
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	int no_sheets;
	
	public ExcelReader(String path) 
	{
		this.path=path;
		
		try
		{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		  no_sheets=workbook.getNumberOfSheets();
		

		}
		catch(Exception e)
		{
			
		}
	}
	
	
	
	
	
	
	public int getRowCount(String sheetname)
	{
		for(int i=0;i<no_sheets;++i)
		{
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetname))
			{
				sheet=workbook.getSheetAt(i);
			}
		}
		
		
	  int rowcount= sheet.getPhysicalNumberOfRows();
	  return rowcount;
	}
	
	public int getColumnCount(String sheetname)
	{
		
		for(int i=0;i<no_sheets;++i)
		{
			if(workbook.getSheetAt(i).getSheetName().equalsIgnoreCase(sheetname))
			{
				sheet=workbook.getSheetAt(i);
			}
		}
		
		
		
	  row = sheet.getRow(0);
	  int colcount = row.getLastCellNum();
	  return colcount;
	  

	}
	
	public String getcellData(int rows,int columns)
	{
	 
		row=sheet.getRow(rows+1);
		String data = row.getCell(columns).getStringCellValue();
         	return data;	
	}
	
		
		
	}
	
	
	
	
	
	
	
	
	
