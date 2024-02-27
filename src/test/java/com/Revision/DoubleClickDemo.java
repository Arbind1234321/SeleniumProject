package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		//Switch to frame
		driver.switchTo().frame("iframeResult");
		//capture the element
		WebElement f1=driver.findElement(By.xpath("//input[@id='field1']"));
		f1.clear();
		f1.sendKeys("Welcome");
		//capture the element to be passed 
		WebElement copy=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		//Create object of action class
		Actions act = new Actions(driver);
		//performing  double click action
		act.doubleClick(copy).perform();
		//validating the text 
		WebElement f2=driver.findElement(By.xpath("//input[@id='field2']"));
		 //String copytext=f2.getText();//--- will not work
		
	   String copytext = f2.getAttribute("value");
	   System.out.println(copytext);
	   if(copytext.equals("Welcome"))
	   {
		   System.out.println("test is passed");
	   }
	   else
	   {
		   System.out.println("test is failed");
	   }
		

	}

}



