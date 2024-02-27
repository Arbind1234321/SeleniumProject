package testngr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DataDrivenDemo {
	WebDriver driver;
	
	@BeforeClass
	void setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	
	@Test(dataProvider="dp")
	void testLogin(String email, String pwd) throws InterruptedException
	{
		driver.get("https://demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

		String exp_title = "nopCommerce demo store";
		Thread.sleep(3000);
		String act_title = driver.getTitle();

		Assert.assertEquals(act_title, exp_title);
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	@DataProvider(name="dp" ,indices = {0,4})
	String [][] loginData()
	{
		String data[][]= {  
							
							{ "arbind1@gmail.com", "test123" },
							{ "arbind12@gmail.com", "test12" },
							{ "arbin2@gmail.com", "test123" },
							{ "arbind12@gmail.com", "test123" },
							{ "arbind12@gmail.com", "test123" }
							
						};
		
		return data;
	}

}
