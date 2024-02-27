package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	    WebDriverManager.chromedriver().setup();
	    WebDriver driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.get("https://www.countries-ofthe-world.com/flags-of-the-world.html");
	    driver.manage().window().maximize();
	    //down casting the webDriver to javaScriptExecutor
	    JavascriptExecutor js=(JavascriptExecutor)driver;
	   
	    //1)scrolling the the page by pixcels
	    js.executeScript("window.scrollBy(0,3000)", " ");
	    System.out.println(js.executeScript("return window.pageYOffset;"));
	    
	    //2)Scrolling the page till element present
	     WebElement flag=driver.findElement(By.xpath("//img[@alt='Flag of India']"));
	    js.executeScript("arguments[0].scrollIntoView()",flag);
	    System.out.println(js.executeScript("return window.pageYOffset;"));
	    
	    //3)Scrolling the page till the end of the documents
	     js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	     Thread.sleep(3000);
	     js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	    

	}

}
