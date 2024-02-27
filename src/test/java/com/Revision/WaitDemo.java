package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WaitDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
	   WebDriver driver  =new ChromeDriver();
	   driver.manage().window().maximize();
	   
	   driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	   //implicit commands
	  // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   //Thread.sleep(time in milli second)
	   //Explicit wait
	   //declerstion
	    WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(10));
	    //usage
	   WebElement ele= mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
	     ele.sendKeys("Admin");
	    
	   //driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
	    WebElement pass=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='password']")));
	    pass.sendKeys("admin123");
	     
	  // driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
	   

	}

}
