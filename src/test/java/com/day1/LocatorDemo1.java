package com.day1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorDemo1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php");
		Thread.sleep(4000);
		//driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
		//driver.findElement(By.name("submit_search")).click();
		//size of slider
		List<WebElement> slider=driver.findElements(By.className("homeslider-container"));
		System.out.println("Total number of slider "+slider.size());
		//total number of image
		List<WebElement> images=driver.findElements(By.tagName("img"));
		System.out.println("Total number of images "+images.size());
		//
	}
	

}
