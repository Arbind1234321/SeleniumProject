package com.Revision;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		//Capture all links of the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("Total numbers of links:"+links.size());
		int brokenlink=0;
		
		for (WebElement link : links)
		{
		      String getAttributevalue=link.getAttribute("href");
		      if(getAttributevalue==null ||getAttributevalue.isEmpty())
		      {
		    	  System.out.println("href attributr value is empty");
		    	  continue;
		      }
		      //convert string to url
		      URL linkurl= new URL(getAttributevalue);
		      //send the request to the server --> open ---connect
		      // connection is open
		     HttpURLConnection conn=(HttpURLConnection) linkurl.openConnection();
		     //now connect the connection
		     conn.connect();
		     if(conn.getResponseCode()>=400)
		     {
		    	 System.out.println(getAttributevalue+"     "+"broken link"); 
		    	 brokenlink++;
		    	 System.out.println("total number of broken link is:"+brokenlink);
		     }
		     else {
		    	 System.out.println(getAttributevalue+"     "+"not broken link");
		     }
		     
		}
		

	}

}
