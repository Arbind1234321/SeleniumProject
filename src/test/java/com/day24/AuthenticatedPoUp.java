package com.day24;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AuthenticatedPoUp {

	public static void main(String[] args) {
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    //https://the-internet.herokuapp.com/basic_auth
	   // https://admin:admin@the-internet.herokuapp.com/basic_auth
	    driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
	    driver.manage().window().maximize(); 
	    //validate
	   String txt =driver.findElement(By.xpath("//p[contains(text(),' Congratulations!')]")).getText();
	   if(txt.contains("Congratulations!"))
	   {
		   System.out.println("test passsed");
	   }
	   else
	   {
		   System.out.println("test failed");
	   }
	}

}
