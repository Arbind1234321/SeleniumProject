package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginTestUsingPageFac {
	 WebDriver driver;

	public LoginTestUsingPageFac(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	 //locator
     @FindBy(xpath="//img[@alt='company-branding']") 
     WebElement img_log;
     
     @FindBy(name="username") 
     WebElement txt_username;
     
     @FindBy(name="password")
     WebElement txt_password;
     
     @FindBy(xpath="//img[@alt='company-branding']") 
     WebElement btn_submit;

	 //Actions Methods
	 public void setUserName(String username)
	 {
		 txt_username.sendKeys(username);
	 }
	 public void setPassword(String password)
	 {
	 	txt_password.sendKeys(password);
	 }
	 public void clickSubmit()
	 {
	 	btn_submit.click();
	 }
	 public boolean checkLogoPresence()
	 {
	 	boolean status=img_log.isDisplayed();
	 	return status;
	 }
}
