package com.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class GetMethods {
	public static void main(String[] args) throws InterruptedException {
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();//deprecated
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
	  String exp_title=driver.getTitle();
	  String act_titlr="OrangeHRM";
	  if(act_titlr.equals(exp_title))
	  {
		  System.out.println("passed");
	  }
	  else
	  {
		  System.out.println("Failed");
	  }
	  Thread.sleep(4000);
	  driver.findElement(By.xpath("//a[normalize-space()='OrangeHR, Inc']")).click();
		
	}

}
