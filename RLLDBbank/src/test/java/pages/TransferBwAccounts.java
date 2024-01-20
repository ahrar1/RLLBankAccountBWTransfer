package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class TransferBwAccounts extends TestBase{
	
	@FindBy(xpath="//a[@id='transfer-menu-item']")
	WebElement TransferBtn;
	
	@FindBy(xpath="//select[@name='fromAccount']")
	WebElement fromAccount;
	
	@FindBy(xpath="//select[@name='toAccount']")
	WebElement toAccount;
	
	
	@FindBy(xpath="//input[@id='amount']")
	WebElement Amount;
	
	@FindBy(xpath="//button[@class='btn btn-primary btn-sm']")
	WebElement submitBtn;
	
	
	@FindBy(xpath="//button[@class='btn btn-danger btn-sm']")
	WebElement resetBtn;
	
	@FindBy(xpath="//strong[text()='Transactions']")
	WebElement succes;
	
	@FindBy(xpath="//span[text()='Error']")
	WebElement unsucces;
	
	
	@FindBy(xpath="//h1[@id='page-title']")
	WebElement res;
	
	public TransferBwAccounts(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}
	
	
	public void transferMoney() {
		TransferBtn.click();
		
	}
	public boolean clickFrom() {
		Select df = new Select(fromAccount);
		
       df.selectByIndex(1);
       
       return fromAccount.isDisplayed();
       
   
      
     
		
		
	}
	
	public boolean clickTo() {
		Select dt = new Select(toAccount);
		 dt.selectByIndex(2);
		 
		 return toAccount.isDisplayed();
		
	}
    
	public boolean enterAmount(String money) {
		Amount.sendKeys(money);
		return Amount.isDisplayed();
		
		
	}
	public void clickSubmit() {
		submitBtn.click();
		
	}
	
	public void clickrest() {
		resetBtn.click();
		
	}
	
	public String validate_transfer_sussceful()
	{
		 String acount_view=res.getText();
		return acount_view;
	}
	public boolean notsucessDisplay() {
		return unsucces.isDisplayed();
	}
	
	public boolean sucessDisplay() {
		return succes.isDisplayed();
	}
	
	
	
	
	public String validate_transfer_unsusscefull()
	{
		String account_view = unsucces.getText();
		return account_view;
		
		
	}
	public boolean deselected() {
		System.out.println("deslected from");
		return fromAccount.isSelected();
	}
	

	
}
