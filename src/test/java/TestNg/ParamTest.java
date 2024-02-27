package TestNg;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ParamTest {
	WebDriver driver;
	@BeforeClass
	@Parameters({"browser","url"})
	void setUpp(String br ,String appurl) {
		if(br.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		}
		else if(br.equals("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		driver.get(appurl);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
	}
	@Test(priority=1)
	void LogoTest() {
		try {
			Thread.sleep(4000);
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
		}
		catch (Exception e) {
			Assert.fail();
		}
		
	}
	@Test(priority = 2)
	void HomePageTitle() {
		Assert.assertEquals(driver.getTitle(),"OrangeHRM","Title not match..");
	}
	@AfterClass
	void closeApp() {
		driver.quit();;
	
	}

}
