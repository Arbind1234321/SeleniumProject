package pageobjectmodel;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {
	WebDriver driver;
	LoginTestUsingPageFac lp;
	@BeforeClass
	void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}
	@Test(priority = 1)
	void testLogo()
	{
		lp=new LoginTestUsingPageFac(driver);
		boolean tp=lp.checkLogoPresence();
		Assert.assertEquals(tp, true);
	}
	@Test(priority = 2)
	void testLogin() {
	  lp.setUserName("Admin");	
	  lp.setPassword("admin123");
	  lp.clickSubmit();
	  Assert.assertEquals(driver.getTitle(), "OrangeHRM");
	}
	@AfterClass
	void tearDown() {
		driver.quit();
	}

}





