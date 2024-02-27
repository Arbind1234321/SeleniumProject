package com.Revision;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutosuggestedDropDown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("Selenium");
		Thread.sleep(4000);
		List<WebElement> list=driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		//count the list size
		System.out.println(list.size());
		//Print all the list of element
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}
		
		//select specific element
		for(int i=0;i<list.size();i++)
		{
		  String text = list.get(i).getText();
		  if(text.equals("selenium download"))
		  {
			  list.get(i).click();
			  break;
		  }
		}

	}

}
