package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SliderElementDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		WebDriver  driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		//Create the action object
		Actions act =new Actions(driver);
		//capture the element
		WebElement min_slider=driver.findElement(By.xpath("//span[1]"));
		//get the current location of element
		System.out.println(min_slider.getLocation());//(59, 250)
		//move the slider as required postion
		act.dragAndDropBy(min_slider, 100, 250).perform();
		// get  new location
		
		System.out.println(min_slider.getLocation());
		
		

	}

}
