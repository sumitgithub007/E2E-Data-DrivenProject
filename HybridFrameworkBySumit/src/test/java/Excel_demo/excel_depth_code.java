package Excel_demo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excel_depth_code {

	 
	public static void main(String args[]) throws IOException  {

		//provide path
		FileInputStream fis = new FileInputStream("C:\\Users\\sumit goyal\\Desktop\\TestCases.xlsx");
		
		 XSSFSheet  sheet=null;
		
		XSSFWorkbook fs = new XSSFWorkbook(fis);
		
	   int sheets =	fs.getNumberOfSheets();
		
		 
	   for(int i=0;i<sheets;++i)
	   {
		   String name = fs.getSheetName(i);
		   
		   if(fs.getSheetName(i).equals("testData"))
		   {
			    sheet=  fs.getSheetAt(i) ;
		   }
		  
	   }
	   //iterator use to accees rows
	   Iterator<Row> rows = sheet.rowIterator();
	   
	   Row  first_row = rows.next(); //come to first row
	   
	  Iterator<Cell> ce = first_row.cellIterator();
	   
	  int column =0;
	  int k=0;
	  
	  while(ce.hasNext())
	  {
		Cell val =  ce.next();
		  
		String name = val.getStringCellValue();
		
		if(val.getStringCellValue().equals("College TC"))
		
		{
		 column=k;
			
		}
		++k;
		  
		  
		  
	  }
	  
	   System.out.println("column no is "+column);
	   
	   
	   Iterator<Row> rows_new_iterator = sheet.rowIterator();
	   
	   
	   while(rows_new_iterator.hasNext())
	   {
		 Row r =  rows_new_iterator.next();
		 
		 String name = r.getCell(column).getStringCellValue();
		   
		 if(r.getCell(column).getStringCellValue().equals("Test2"))
		 {
			
			 Iterator<Cell> cv = r.cellIterator();
			 
		 	 
			 while(cv.hasNext())
			 {
               Cell c = cv.next();				 
			 
               if(c.getCellType().equals(CellType.NUMERIC))
               {
            	   c.setCellValue(766);
            	   System.out.println(c.getNumericCellValue());
            	 
            				
               }
               else
               {
               System.out.println(c.getStringCellValue());
               }
			 
			 }
			 
			 
			 
			 
			 
		 }
		 
		 
		   
		   
	   }
	   
	   
	   
	   
	   
	   
		
		
		
	}

}
