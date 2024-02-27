package com.Revision;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Pagination {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		// 1)count total number of rows
		int rows = driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size();
		int cols = driver.findElements(By.xpath("//table[@id='productTable']//thead/tr/th")).size();
		driver.manage().window().maximize();
		Double sum = 0.00;
		for (int p = 1; p <= 4; p++) {
			driver.findElement(By.xpath("//ul[@class='pagination']/li[" + p + "]")).click();

			Thread.sleep(3000);
			/*
			 * for(int r=1;r<=rows;r++) { for(int c=1;c<=4;c++) {
			 * 
			 * String details=
			 * driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+
			 * "]/td["+c+"]")).getText();
			 * 
			 * System.out.print(details+"  "); } System.out.println(); }
			 */

			for (int r = 1; r <= rows; r++) {
				String text = driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr[1]/td[3]")).getText();
				// System.out.println(text);

				String s = text;
				String newstring = s.replace("$", "");
				sum = sum + Double.parseDouble(newstring);

			}

		}
		System.out.println(sum);
	}

}
