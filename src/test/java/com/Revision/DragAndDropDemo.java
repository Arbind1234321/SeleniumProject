package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDropDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
		driver.manage().window().maximize();
		//create the object of action class
        Actions act= new Actions(driver);
        //capture source element
        WebElement rome=driver.findElement(By.xpath("//div[@id='box6']"));
        //capture target element
        WebElement italy = driver.findElement(By.xpath("//div[@id='box106']"));
        //perform action
        act.dragAndDrop(rome, italy).build().perform();
        
	}

}
