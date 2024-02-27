package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RightClickDemo {

	public static void main(String[] args) {
		 WebDriverManager.chromedriver().setup();
		 WebDriver driver=  new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.get("http://swisnl.github.io/jQuery-contextMenu/demo.html");
		 driver.manage().window().maximize();
		 //Capturing element
		 WebElement button=driver.findElement(By.xpath("//span[@class='context-menu-one btn btn-neutral']"));
		 //Creating the object of action class
		 Actions act =new Actions(driver);
		 //performing right click action
		 act.contextClick(button).perform();
		 //clicking on copy
		 driver.findElement(By.xpath("//span[normalize-space()='Copy']")).click();
		 //Handling alert window i.e closing alert window
		 driver.switchTo().alert().accept();
		 
		 

	}

}
