package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POMSignIn extends TestBase{
	
	@FindBy(xpath="//input[@id='username']")
	WebElement user;
	

	@FindBy(xpath="//input[@id='password']")
	WebElement pass;
	
	@FindBy(xpath="//button[text()='Sign in']")
	WebElement signin;
	
	
	public POMSignIn(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void signPage() {
		 user.sendKeys("ar@gmail.com");
		 pass.sendKeys("Mila7064duna@");
		 signin.click();
		
	}
	
	
	
	

}
