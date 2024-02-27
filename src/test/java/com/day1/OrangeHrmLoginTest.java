package com.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
public class OrangeHrmLoginTest {

	public static void main(String[] args) {
		//System.setProperty("webdriver.chrome.driver", "C:\\Drivers\\chromedriver_win32\\chromedriver.exe");
		//WebDriverManager.chromedriver().setup();

		WebDriver driver =new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com");
		driver.manage().window().maximize();
		WebElement e_id=driver.findElement(By.id("Email"));
		e_id.clear();
		e_id.sendKeys("admin@yourstore.com");
	    WebElement	pwd=driver.findElement(By.id("Password"));
	    pwd.clear();
	    pwd.sendKeys("admin");
	    driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	    String  act_txt=driver.findElement(By.xpath("//h1[normalize-space()='Dashboard']")).getText();
	    String exp_txt="Dashboard";
	    if(act_txt.equals(exp_txt))
	    {
	    	System.out.println("passed");
	    }
	    else
	    {
	    	System.out.println("failed");
	    }
	    driver.quit();
		
		
	}

}
