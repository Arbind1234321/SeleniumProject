package com.Revision;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingDropDown {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		WebElement drpcountryLst=driver.findElement(By.xpath("//select[@id='country']"));
		//Create the object of select class
		Select drp_country=new Select(drpcountryLst);
		//select specific country 
		drp_country.selectByVisibleText("Germany");
		//Total number of drop down through getoptions() method
		
		   List<WebElement> options=drp_country.getOptions();
		   System.out.println(options.size());
		
		//Print These options
        /* for(int i=0;i<options.size();i++)
         {
        	System.out.println(options.get(i).getText());
         }*/
		   //using enhanced loop
		   
		   for(WebElement opt:options)
		   {
			   if(opt.getText().contains("Un"))
			   System.out.println(opt.getText());
		   }
	}

}
