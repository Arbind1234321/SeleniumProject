package com.Revision;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetWindowHandles {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		Thread.sleep(4000);
		driver.findElement(By.xpath("//a[contains(.,'OrangeHRM, Inc')]")).click();
		Set<String> windowsids =driver.getWindowHandles();
		for(String winid:windowsids)
		{
			System.out.println(winid);
		}
		

	}

 }
