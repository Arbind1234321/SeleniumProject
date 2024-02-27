package com.Revision;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDoownDatePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperties(null);
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.dummyticket.com/dummy-ticket-for-visa-application/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//input[@type='text' and @id='dob']")).click();
        String year="2022";
        String month="Mar";
        String date="23";
        //month
        WebElement month_lst=driver.findElement(By.xpath("//select[@aria-label='Select month']"));
        Select drp_month=new Select(month_lst);
        drp_month.selectByVisibleText(month);
        //year
        WebElement year_lst=driver.findElement(By.xpath("//select[@aria-label='Select year']"));
        Select drp_year=new Select(year_lst);
        drp_year.selectByVisibleText(year);
        //Select date
       List<WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td"));
     /*  for(WebElement dd:alldates)
       {
    	   if(dd.getText().equals(date))
    	   {
    		   dd.click();
    		   break;
    	   }
       }*/
       for(int i=0;i<alldates.size();i++)
       {
    	   if(alldates.get(i).getText().equals(date))
    	   {
    		   alldates.get(i).click();
    		   break;
    	   }
       }
       
        
	}

}
