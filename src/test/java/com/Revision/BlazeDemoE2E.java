package com.Revision;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BlazeDemoE2E {
	private void psvm() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		// selecting option
		WebElement drplst = driver.findElement(By.xpath("//select[@name='fromPort']"));

		// Create object of select class
		Select selecct_lst = new Select(drplst);
		// selecting element by vissible text
		selecct_lst.selectByVisibleText("Boston");
		// selecting Another dropdown
		WebElement to_lst = driver.findElement(By.xpath("//select[@name='toPort']"));

		Select selecct_lst1 = new Select(to_lst);
		// selecting element by vissible text

		selecct_lst1.selectByVisibleText("Berlin");
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		//Capturing price from table
		List< WebElement>pricelst=driver.findElements(By.xpath("//table[@class='table']//tbody/tr/td[6]"));
		System.out.println(pricelst.size());
		//Printing  all prices
		double [] a=new double[5];
		double  sum=0;
		double max=.00;
		int num=0;
		Double price=0.0;
		for(int i=1;i<=5;i++)
		{
			String st=driver.findElement(By.xpath("//table[@class='table']//tbody/tr["+i+"]/td[6]")).getText();
			String text=st.replace('$',' ');
			
			 price=Double.parseDouble(text);
			 System.out.println(price);
			//sum=sum+price;
			a[i-1]=price;
			if(max<price) {
				max=price;
				num=i;
			}
			
		}
		  Arrays.sort(a);
		  Double lowstprice=a[0];
		  System.out.println(lowstprice);
		  
		  for(int r=1;r<=5;r++)
		  {
			  if(Double.compare(price,lowstprice)==1)
				{
				    //driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
					driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[1]//input")).click();
					break;
				}
		  }
		
		//driver.findElement(By.xpath("//table[@class='table']//tbody/tr["+num+"]/td[1]//input")).click();
		//System.out.println(Arrays.toString(a));
		//System.out.println(max);
		System.out.println(num);
		
		

	}
}

