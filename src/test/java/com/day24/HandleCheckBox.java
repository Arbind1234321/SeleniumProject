package com.day24;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) throws InterruptedException{
		Scanner sc=new Scanner(System.in);
		WebDriverManager.chromedriver().setup();
		 WebDriver driver= new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 driver.manage().window().maximize();
		 driver.get("https://itera-qa.azurewebsites.net/home/automation");
		 //selecting specific element
		 // driver.findElement(By.xpath("//input[@id='monday']")).click();
		 //total number of check box
		 List <WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
        // System.out.println("total number of checkbox are:"+checkboxes.size() );
		/* for(int i=0;i<checkboxes.size();i++)
		 {
			 checkboxes.get(i).click();
		 }*/
		/* for(WebElement chkbox:checkboxes)
		 {
			 chkbox.click();
		 }*/
		 //for last two check box
		 //for starting index = total number of check box - number of selected box
		 //7-2=5
		/* System.out.println("how many element you want to select from last");
		 int num=sc.nextInt();
		 for(int i=(checkboxes.size()-num);i<checkboxes.size();i++)
		 {
			 checkboxes.get(i).click(); 
		 }*/
		 //first two check box
		/*  for(int i=0;i<checkboxes.size();i++)
		 {
			 checkboxes.get(i).click();
		 }*/
		/* for (int i=0;i<checkboxes.size();i++)
		 {
			 if(i<2)
			 {
				 checkboxes.get(i).click();
			 }
		 }*/
		 //clear check boxes
		/* for(int i=0;i<checkboxes.size();i++)
		 {
			 checkboxes.get(i).click();
		 }
		 
		 Thread.sleep(4000);
		 for(int i=0;i<checkboxes.size();i++)
		 {
			 checkboxes.get(i).click();
		 }*/
		 for(int i=0;i<2;i++)
		 {
			 checkboxes.get(i).click();
		 }
		 Thread.sleep(4000);
		 for(int i=0;i<checkboxes.size();i++)
		 {
			 if(checkboxes.get(i).isSelected())
			 {
			 checkboxes.get(i).click();
			 }
		 }
	}
}
