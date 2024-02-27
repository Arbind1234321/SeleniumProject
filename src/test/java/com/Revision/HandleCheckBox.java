package com.Revision;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		//Selecting Specifics checkBoxes
		//driver.findElement(By.xpath("//input[@id='wednesday']")).click();
	   // selecting all element at a time
		
	List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
     //count total checkbox 
	System.out.println("Total check box is :"+checkboxes.size());
	//Selecting all check box
	// by using normal check box
	/*for(int i=0;i<checkboxes.size();i++)
	{
		checkboxes.get(i).click();
	}*/
	//by using Enhanced for loop
	/*for(WebElement chbox:checkboxes)
	{
	  chbox.click();	
	}*/
	//Selecting last two element
	for(int i=checkboxes.size()-2;i<checkboxes.size();i++)
	{
		checkboxes.get(i).click();
	}
	//unselecting only selected checkbox
	for(int i=0;i<3;i++)
	{
		checkboxes.get(i).click();
	}
	Thread.sleep(5000);
	for(int i=0;i<checkboxes.size();i++)
	{
		if(checkboxes.get(i).isSelected())
		{
		checkboxes.get(i).click();
		}
	}
	
	}

}










