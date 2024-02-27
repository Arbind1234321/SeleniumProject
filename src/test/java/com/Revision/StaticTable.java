package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		//1)count number of rows
		 int rows= driver.findElements(By.xpath("//table[@name='BookTable']/tbody/tr")).size();
		  System.out.println("Total number of rows : "+rows);
		//2)count number of cols
		  int cols=driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		  System.out.println("Total number of columns : "+cols);
		//3)specific rows and columns data
		  String val=driver.findElement(By.xpath("//table[@name='BookTable']//tr[3]/td[2]")).getText();
		  System.out.println("The given text is :"+val);
	    //4) Read data from all rows and columns
		 /* for(int r=2;r<=rows;r++)
		  {
			for(int c=1;c<=cols;c++)
			{
				String txt=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]/td["+c+"]")).getText();
				System.out.print(" "+txt);
			}
			System.out.println();
		  }*/
		  
		  //Read specific columns
		 /* for(int row=2;row<rows;row++)
		  {
			  String txt=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]/td[2]")).getText();
				System.out.println(" "+txt);
		  }*/
		  
		//print books names whose Author is amit
		  
		 /* for(int row=2;row<=rows;row++)
		  {
			  String txt=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]/td[2]")).getText();
			  if(txt.equals("Amit"))
			  {
				 String book=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]/td[1]")).getText();
				System.out.println(" "+book);
			  }
			 
		  }*/
		  //6)find sum of all prices  of all books
		/*  int sum=0;
		  for(int row=2;row<=rows;row++)
		  {
			  String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]/td[4]")).getText();
			  
			//  sum=sum+Integer.parseInt(price);
			  sum=sum+Integer.valueOf(price);
			 
		  }
		  System.out.println(sum);
		  */
		  //7)print the most costly book
		  int sum=0;
		  int max=0;
		  int num=0;
		  for(int row=2;row<=rows;row++)
		  {
			  String price=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+row+"]/td[4]")).getText();
			     int st=Integer.parseInt(price);
			     //System.out.println(st);
			  
			  if(max<st)
			  {
				  max=st;
				  num=row;
				  
			  }
			 
		  }
		  
		  System.out.println(num);
		 String maxprice_book=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+num+"]/td[1]")).getText();
		 System.out.println(maxprice_book);
		  
		 
	}

}










