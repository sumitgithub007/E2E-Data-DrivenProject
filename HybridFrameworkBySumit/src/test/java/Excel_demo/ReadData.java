package Excel_demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class ReadData {

	 
    public static void main(String[] args) throws IOException  {
		
    	// You need to use File class which will ask for file location.I specified  base// directory //using dot(.) operator then inside data folder I have testdata.xls// stored
   	 
    	//File src=new File("C:\\Users\\sumit goyal\\Desktop\\Writesheet.xlsx");
    	 
    	FileInputStream fis = new FileInputStream("C:\\Users\\sumit goyal\\Desktop\\Writesheet.xlsx");

    	XSSFWorkbook xssf = new XSSFWorkbook(fis);
    	
    	
    	XSSFSheet sheet = xssf.getSheetAt(0);
    	
    	
    	int rowcount = sheet.getLastRowNum();
    	 Row row = sheet.getRow(0);
    	  int colcount = row.getLastCellNum();
    	  System.out.println(colcount);
    	System.out.println(rowcount);
    	
    	for(int i=1;i<rowcount;++i)
    	{
    		String data1 =sheet.getRow(i).getCell(0).getStringCellValue();
    		System.out.print(data1 + "    ");
    		
    		String data2 =sheet.getRow(i).getCell(1).getStringCellValue();
    		System.out.print(data2+ "      ");

    		String data3 =sheet.getRow(i).getCell(2).getStringCellValue();
    		System.out.print(data3);

    		
    	
    		
    		System.out.println();
    		
    		
    	}
    	
 
    	//double data4 =sheet.getRow(0).getCell(3).getNumericCellValue();
		//System.out.print(data4);

		
    	
    	
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}