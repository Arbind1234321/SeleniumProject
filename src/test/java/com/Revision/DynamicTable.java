package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicTable {

	public static void main(String[] args) throws InterruptedException {
	 WebDriverManager.chromedriver().setup();
	 WebDriver driver=new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	 driver.get("https://demo.opencart.com/admin/index.php?route=common/login");
	 driver.manage().window().maximize();
	 driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
     driver.findElement((By.xpath("//input[@id='input-password']"))).sendKeys("demo");
     driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
     //closing pop up
     driver.findElement(By.xpath("//button[@class='btn-close']")).click();
     //Thread.sleep(5000);
     //customers---->customer
     
     driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
     driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
     //1)capture specific data from rows and columns
     String txt=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tr[2]/td[3]")).getText();
     System.out.println(txt);
     //1)count rows and cloumns
     int cols=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//thead/tr/td")).size();  
     int rows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr")).size();
     System.out.println(cols);
     System.out.println(rows);
     //print specific row of the  table
    /* for(int row=1;row<=rows;row++)
     {
    	String data= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+row+"]/td[3]")).getText();
    	System.out.println(data);
     }*/
     //Display complete page
   /* for(int r=1;r<=rows;r++)
     {
    	 for(int c=2;c<=6;c++)
    	 {
          
    		 String details= driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody/tr["+r+"]/td["+c+"]")).getText();
    	
    		 System.out.print(details+"  ");
    	 }
    	 System.out.println();
     }
     */
     // count total number of pages
     String text=driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
     // System.out.println(text);
      
     int total_pages= Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
     //System.out.println(total_pages);
     //  driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()=2]")).click();
     
     for(int p=3;p<=4;p++)
     {
    	driver.findElement(By.xpath("//ul[@class='pagination']/li["+p+"]")).click();
    	Thread.sleep(3000);
     }
    
     
  
     
     
     
     
       
	}

}








