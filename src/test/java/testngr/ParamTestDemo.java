package testngr;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParamTestDemo 
{ 
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser","url"})
  void setUp(String br,String url)
  { 
	if(br.equals("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	}
	else if(br.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver=new EdgeDriver();
	}
	else {
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get(url);
	driver.manage().window().maximize();
  }
	@Test(priority = 1)
  void testLogo() {
	  try {
	  boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	  //Assert.assertTrue(status);
	  Assert.assertEquals(status,true);
	  }catch (Exception e) {
		Assert.fail();
	}
  }
	@Test(priority = 2, invocationCount = 3)
  void homepageTitle() {
		 Assert.assertEquals(driver.getTitle(),"OrangeHRM","Tirle are not matched");
	  
  }
	@AfterClass
	void closeApp() {
		driver.quit();
		
	}
}












