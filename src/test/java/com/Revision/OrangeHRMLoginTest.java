package com.Revision;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLoginTest {
	public static void main(String[] args) {
		
		//Launch browser
		//System.setProperty("webdriver.chrome.driver","C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		
		WebDriverManager.chromedriver().setup();
		//create object of chromedriver 
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.get("https://demo.opencart.com/");
		String text=driver.findElement(By.xpath("//a[text()='MacBook']")).getText();
		System.out.println(text);
		
		System.out.println(driver.getTitle());
		System.out.println("hhhhh");
		//driver.close();
	}

}
