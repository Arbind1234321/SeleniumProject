package com.Revision;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenShot {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//capture full page screen shot
//		TakesScreenshot ts= (TakesScreenshot)driver;
//		//capture screenshot through getScreenshotAs()
//		File src=ts.getScreenshotAs(OutputType.FILE);
//		//create the object of file
//		File trg=new File("C:\\Users\\aRBIND\\eclipse-workspace\\seleniumproject\\ScreenShot\\fullpage.png");
//		//combine src and trg
//		FileUtils.copyFile(src, trg);
		
		//Capture the screenShot of specific area
//	  WebElement f_product=driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
//	     File src=f_product.getScreenshotAs(OutputType.FILE);
//	     File trg=new File("C:\\Users\\aRBIND\\eclipse-workspace\\seleniumproject\\ScreenShot\\featureproduct.png");
//	     //copying src to trg
//	     FileUtils.copyFile(src, trg);
		
		//capture the screen shot of specific element
	
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
	     File src=logo.getScreenshotAs(OutputType.FILE);
	     File trg=new File("C:\\Users\\aRBIND\\eclipse-workspace\\seleniumproject\\ScreenShot\\logo.png");
	     //copying src to trg
	     FileUtils.copyFile(src, trg);
	   
	  
	  
	  

	}

}
