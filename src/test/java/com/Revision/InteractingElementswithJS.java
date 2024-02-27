package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class InteractingElementswithJS {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		//interacting with input box
		WebElement input = driver.findElement(By.xpath("//input[@id='name']"));
		js.executeScript("arguments[0].setAttribute('value','Arbnd')", input);
		
		//interacting with radio button
		WebElement Rd_button=driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click();",Rd_button);
		
		//checkBoexes
		WebElement chk_box=driver.findElement(By.xpath("//input[@id='tuesday']"));
		js.executeScript("arguments[0].click();",chk_box);
		
		//button  //input[@name='Submit']
		driver.switchTo().frame("frame-one796456169");
		
		WebElement button=driver.findElement(By.xpath("//input[@name='Submit']"));
		js.executeScript("arguments[0].click();",button);
		String st;
		
		

	}

}
