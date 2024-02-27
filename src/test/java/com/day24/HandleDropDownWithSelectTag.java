package com.day24;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleDropDownWithSelectTag {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://phppot.com/demo/jquery-dependent-dropdown-list-countries-and-states/");
		driver.manage().window().maximize();
		WebElement drpcountryEle = driver.findElement(By.xpath("//select[@name='country']"));
		Select drpcountry =new Select(drpcountryEle);
		//Selecting each element from drop down
		//drpcountry.selectByVisibleText("USA");
		//drpcountry.selectByValue("3");//string type
		//drpcountry.selectByIndex(4);
		
		//Total options in drop down
		List<WebElement> options=drpcountry.getOptions();
		System.out.println("Total number of options "+options.size());
		/*for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		*/
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}

	}

}
