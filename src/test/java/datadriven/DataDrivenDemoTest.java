package datadriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//for reading excel
public class DataDrivenDemoTest {

	public static void main(String[] args) throws IOException {
		//1) create the file input Stream  object
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\data.xlsx");
		//Excel file-->work book-->sheet-->rows-->cell
		//2)Capture work book
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		//3)capture  specific sheet
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		//4)count totalnumber of rows
		 int total_rows=sheet.getLastRowNum();
		 //5)get total number of cell from row
		 int total_cell=sheet.getRow(total_rows).getLastCellNum();
	    //6)Capture rows and its cell
		 for(int r=0;r<=total_rows;r++)
		 {
			 //7)get specific rows from sheet
			 XSSFRow current_row= sheet.getRow(r);
			 for(int c=0;c<total_cell;c++)
			 {
				 //8)getting data from each rows
				 String value=current_row.getCell(c).toString();
				 System.out.print(value+"  ");
			 }
			 System.out.println();
		 }
		 workbook.close();
		 file.close();

	}

}
