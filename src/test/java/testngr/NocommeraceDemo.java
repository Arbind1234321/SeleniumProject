package testngr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(testngr.ExtentReportManager.class)
public class NocommeraceDemo {
	WebDriver driver;
	@BeforeClass
	void setUp() {
     WebDriverManager.chromedriver().setup();
     driver=new ChromeDriver();
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     driver.get("https://demo.nopcommerce.com/login");
     driver.manage().window().maximize();
	}
	@Test(priority = 1)
	void TestLogo() {
	try {
		boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		Assert.assertEquals(status, true);
	}catch (Exception e) {
		Assert.fail();
	}
	}
	@Test(priority = 2)
	void testLogin() {
		try {
			
			driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("aaa@gmail.com");
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("test123");
			driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
			//validation
			boolean status=driver.findElement(By.xpath("//a[@class='ico-account']")).isDisplayed();
			Assert.assertEquals(status, true);
		} catch (Exception e) {
		Assert.fail();
		}
	}
	@Test(priority = 3,dependsOnMethods = {"testLogin"})
	void LogoutTest() {
		try {
			driver.findElement(By.xpath("//a[normalize-space()='Log out']")).click();
			boolean status=driver.findElement(By.xpath("//a[normalize-space()='Register']")).isDisplayed();
			Assert.assertEquals(status, true);
			
		} catch (Exception e) {
			// TODO: handle exception
			Assert.fail();
		}
		
		
	}
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
}
