package com.w2a.utilities;

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
	public FileOutputStream fileOut=null;
	public XSSFWorkbook workbook=null;
	public XSSFSheet sheet=null;
	public XSSFRow row=null;
	public XSSFCell cell=null;
	
	
	public ExcelReader(String path) 
	{
		this.path=path;
		
		try
		{
		fis = new FileInputStream(path);
		workbook = new XSSFWorkbook(fis);
		sheet=workbook.getSheetAt(0);
		}
		catch(Exception e)
		{
			
		}
	}
	
	public int getRowCount()
	{
	  int rowcount= sheet.getPhysicalNumberOfRows();
	  return rowcount;
	}
	
	public int getColumnCount()
	{
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
	
	
	
	
	
	
	
	
	
