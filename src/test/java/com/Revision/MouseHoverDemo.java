package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseHoverDemo {

	public static void main(String[] args) {
		  WebDriverManager.chromedriver().setup();
		  WebDriver driver=new ChromeDriver();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  driver.get("https://demo.opencart.com/");
		  driver.manage().window().maximize();
		  //get the element on which we are performing mouse action
		  WebElement desktops=driver.findElement(By.xpath("//a[normalize-space()='Desktops']"));
		  WebElement mac=driver.findElement(By.xpath("//a[normalize-space()='Mac (1)']"));
		  Actions act =new Actions(driver);
		  //mouse hover
		  //Perform action on build method
		 // act.moveToElement(desktops).moveToElement(mac).click().build().perform();//Creating action the performin
		  act.moveToElement(desktops).moveToElement(mac).click().build().perform();

	}

}
