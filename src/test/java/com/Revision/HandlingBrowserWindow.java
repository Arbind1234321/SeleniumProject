package com.Revision;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingBrowserWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub    
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		//capture windows ids
		Set <String>windowids=driver.getWindowHandles();
		List <String> windowidslist=new ArrayList<String>(windowids);
	    String	parentId=windowidslist.get(0);
	    String	childId=windowidslist.get(1);
	    //switch to child window
	    driver.switchTo().window(childId);
	    driver.findElement(By.linkText("Contact Sales")).click();
	    //switching to parent id
	    driver.switchTo().window(parentId);
	    driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Arbind");
	    
	    
	    
	    

	}

}
