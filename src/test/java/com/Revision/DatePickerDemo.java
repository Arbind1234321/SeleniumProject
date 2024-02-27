package com.Revision;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DatePickerDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='datepicker']")).click();
		String year="2025";
		String month="March";
		String date="12";
		//Selecting year and month future date
		while (true) 
		{
		    String yr=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		    String mon=driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
		    if(yr.equals(year)&&mon.equals(month))
		    {
		    	break;
		    }
		    
		    driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		//select date
		List <WebElement> alldates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody/tr/td"));
		/*for(WebElement dt:alldates)
		{
			if(dt.getText().equals(date))
			{
			dt.click();
			break;
			}
		}*/
		//using normal loop
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
