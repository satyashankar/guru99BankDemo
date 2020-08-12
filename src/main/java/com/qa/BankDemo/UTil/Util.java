package com.qa.BankDemo.UTil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.charts.XSSFDateAxis;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.google.common.collect.Table.Cell;
import com.qa.BankDemo.BasePage.BasePage;

public class Util extends BasePage{
	
	   public static HSSFWorkbook workBook;
		public static HSSFSheet sheet;	
		public static  HSSFRow row;
		public static HSSFCell cell;
		
		public Util(String excelPath, String sheetName)throws IOException {
			
			try {
				FileInputStream fileInputStream= new FileInputStream(excelPath);
				workBook = new HSSFWorkbook(fileInputStream);			
			   sheet = workBook.getSheet(sheetName);
			} catch (Exception e) { 
				   			   			
				e.printStackTrace();
			}
			
		}
		public static  Object[][] testData(String excelPath, String sheetName) throws IOException {
			Util excel = new Util(excelPath,sheetName);
			
			int  rowCount= excel.getRowCount();
			int colCount = excel.getColCount();
			
			Object  data[][]= new Object[rowCount-1][colCount];
			
			for (int i=1; i<rowCount;i++) {
				for (int j=0; j<colCount; j++) {
				String cellData = excel.getCellData(i, j);
					
					data[i-1][j] = cellData;
				}
			}
			return data;
			
			}

	public static int getRowCount (){  	 
		
		   // Access the required test data sheet
           int rowCount = 0;
		   try {
		  rowCount= sheet.getPhysicalNumberOfRows();
		  System.out.println(rowCount);
		  
		   } catch (Exception e) { 			   
				e.printStackTrace();
			}
		   return rowCount;
		   }
	
	
	  public int getColCount(){		  
		   // Access the required test data sheet
          int colCount=0;
          
		   try {			
		   colCount= sheet.getRow(0).getPhysicalNumberOfCells();
		   System.out.println(colCount);			  
		   } catch (Exception e) {
			 // TODO Auto-generated catch block
				e.printStackTrace();
			}
		   return colCount;
	  }
	  

		   public String getCellData(int rowNum, int colNum){  	  

			 
			   // Access the required test data sheet

			   try {
				   //sheet = workBook.getSheet(sheetName);
				    row  = sheet.getRow(rowNum);
				    cell= row.getCell(colNum);
				    
				    if (cell.getCellTypeEnum()== CellType.STRING) {
				    String cellVal= cell.getStringCellValue();
				    System.out.println(cellVal);
				    String data= cellVal;
				    return data;
				    }
				    	else if(cell.getCellTypeEnum()== CellType.NUMERIC)
				    	{
					    	double cellData = cell.getNumericCellValue();
					    	// Get it formatted as a string
					    	 DataFormatter formatter = new DataFormatter();
					    	 String cellAsStr = String.valueOf(cellData);
					    	 System.out.println(cellAsStr);
					    	 return cellAsStr;
					    	
				    	}
				    	else if(HSSFDateUtil.isCellDateFormatted(cell))
				    	{
				    		DateFormat dt = new SimpleDateFormat("mm/dd/yyyy");
				    				Date date = cell.getDateCellValue();
				    			    String  cellDate= dt.format(date);	
				    				System.out.println(cellDate);
				    				return cellDate;
				    	}		    	
				    	    	
				   				    
				   
			   } catch (Exception e) { 	 				   
				   
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			   return "xxx";



	}	   	
		   
			
	
}