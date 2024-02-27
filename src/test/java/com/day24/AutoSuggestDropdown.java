package com.day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutoSuggestDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//textarea[@name='q']")).sendKeys("selenium");
		List<WebElement>list=driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')][ @role='presentation']//span"));
		//count the total suggestion
		System.out.println("Total number of suggest list: "+list.size());
		Thread.sleep(5000);
		for(int i=0;i<list.size();i++)
		{
			String text=list.get(i).getText();
			//System.out.println(list.get(i).getText());
			if(text.equals("selenium java"))
			{
				list.get(i).click();
				break;
			}
		}

	}

}
