package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandlingInnerFrames {

	public static void main(String[] args) {
	     WebDriverManager.chromedriver().setup();
	      WebDriver driver=new ChromeDriver();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	      driver.get("https://ui.vision/demo/webtest/frames/");
	      driver.manage().window().maximize();
	      //frame 1
	      WebElement frm1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
	      
	      driver.switchTo().frame(frm1);
	      driver.findElement(By.xpath("//input[@type='text']")).sendKeys("agagagg");
	      // switch back to main page
	      driver.switchTo().defaultContent();
	      //frame 2
	      WebElement frm2=driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
	      driver.switchTo().frame(frm2);
	      //send data in second frame input
	      driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("fdhsjj");
	      driver.switchTo().defaultContent();
	      
	      //interating with inner frame
	      WebElement frm3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
	      driver.switchTo().frame(frm3);
	      driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("333333");
	      
	      //inner frame
	      driver.switchTo().frame(0);
	      driver.findElement(By.xpath("//body/div[@class='Uc2NEf']/div[@class='teQAzf']/form[@id='mG61Hd']/div[@class='RH5hzf RLS9Fe']/div[@class='lrKTG']/div[@role='list']/div[1]/div[1]/div[1]")).click();
	      
	      
	      
	      

	}

}
