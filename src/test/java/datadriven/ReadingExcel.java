package datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Reading data from excel
public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		//Create inputfileStream object
		//FileInputStream file=new FileInputStream("C:\\Users\\aRBIND\\eclipse-workspace\\seleniumproject\\TestData\\data.xlsx");
		//using current project location
		FileInputStream file=new FileInputStream(System.getProperty("user.dir") + "\\TestData\\data.xlsx");
		
		//Excel file-->WorkBook-->sheet-->rows-->cell
		//Capture work book
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//get the specific sheet name
		 //XSSFSheet sheet=workbook.getSheet("Sheet1");
		 //using sheet index 
		   XSSFSheet sheet=workbook.getSheetAt(0);
		 //capture the rows and cell using sheet
		   
		 //count total the rows
		 //rows number start with zero
		 int totalrows=sheet.getLastRowNum();
		 System.out.println(totalrows);
		 //count total cell
		 //Cell number start with one
		 int totalCell = sheet.getRow(1).getLastCellNum();
		 System.out.println(totalCell);
		 //for printing the cell data we use loops
		 //first read rows then columns
		 for(int r=0;r<=totalrows;r++)
		 {
			 //get the specific rows from sheet
			 XSSFRow currentrow=sheet.getRow(r);
			 for(int c=0;c<totalCell;c++)
			 {
				// String value=currentrow.getCell(c).toString();
				// System.out.print(value+"  ");
				XSSFCell currentcell=currentrow.getCell(c);
				String value =  currentcell.toString();
				System.out.print(value+"  ");
			 }
			 System.out.println();
		 }
		 workbook.close();
		 file.close();
		 

	}
	
	
	
	
	
	
	

}
