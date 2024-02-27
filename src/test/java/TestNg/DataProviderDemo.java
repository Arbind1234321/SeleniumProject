package TestNg;

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

public class DataProviderDemo {
	WebDriver driver;

	@BeforeClass
	void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	}

	@Test(dataProvider = "dp")
	void login(String email, String pwd) {
		driver.get("https://demo.nopcommerce.com/login");
		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();

		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();
		Assert.assertEquals(exp_title, act_title);

	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

	@DataProvider(name = "dp" , indices = {3,5})
	String[][] logonData() {

		String data[][] = { { "abc@gmail.com", "test123" }, { "pavanol@gmail.com", "test@123" },
				{ "arbind123@gmail.com", "arbind123" }, { "pavanoltraining@gmail.com", "test3" },
				{ "pavanoltraining@gmail.com", "test@123" }, { "arbind123@gmail.com", "arbind123" },
				{ "arbind123@gmail.com", "arbind123" }, { "pavanoltraining@gmail.com", "test@123" } };

		return data;

	}
}
