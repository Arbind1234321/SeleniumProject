package com.day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Java");
		List<WebElement>list=driver.findElements(By.xpath("//div[contains(@class,'wM6W7d') and (@role='presentation')]//span"));
       System.out.println(list.size());
       for(WebElement lt:list)
       {
    	   //System.out.println(lt.getText());
    	   String txt=lt.getText();
    	   if(txt.equals("javascript"))
    	   {
    		   lt.click();
    		   break;
    	   }
       }
	}

}
