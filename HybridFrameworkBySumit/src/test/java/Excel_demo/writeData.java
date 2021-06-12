package Excel_demo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 
public class writeData {

	 
    public static void main(String[] args) throws IOException  {
		
    	// You need to use File class which will ask for file location.I specified  base// directory //using dot(.) operator then inside data folder I have testdata.xls// stored
    	 
    	File src=new File("C:\\Users\\sumit goyal\\Desktop\\Writesheet.xlsx");
    	 
    	FileInputStream fis = new FileInputStream(src);

    	XSSFWorkbook xssf = new XSSFWorkbook(fis);
    	
    	
    	XSSFSheet sheet = xssf.getSheetAt(0);
    	
    	 sheet.getRow(0).createCell(3).setBlank();
    	 
    	 FileOutputStream fos = new FileOutputStream(src);
    	 
    	 
    	 xssf.write(fos);
    	 
    	 
    	 xssf.close();
    	 
    	 
    	 
    	 
}
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}