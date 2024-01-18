package stepdef;


import static org.testng.Assert.assertEquals;

import org.junit.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.POMSignIn;
import pages.TestBase;
import pages.TransferBwAccounts;

public class TranferPage extends TestBase {
	POMSignIn sg;
	TransferBwAccounts tf ;
	SoftAssert sf = new SoftAssert();
	
	@Given("I am on signin page")
	public void i_am_on_signin_page() {
		
		 try {
			 getBrowser();
		 }
		 catch(Exception e) {
			 sf.fail("Unable to open browser");
		 }
		
		
	}

	@Then("i will sign in with valid credentials")
	public void i_will_sign_in_with_valid_credentials() {
		sg = new POMSignIn(driver);
		sg.signPage();
	}

	@Then("i click on  the  transfer amount page")
	public void i_click_on_the_transfer_amount_page() {
		tf=new TransferBwAccounts(driver);
		tf.transferMoney();
	}

	@Then("i will select the from account")
	public void i_will_select_the_from_account() {
		sf.assertTrue(tf.clickFrom()) ;
	   
	}

	@Then("i will select the to account")
	public void i_will_select_the_to_account() {
		sf.assertTrue( tf.clickTo());
	}

	@Then("I enter amount as {string} on the page")
	public void i_enter_amount_as_on_the_page(String Amount) {
		sf.assertTrue(tf.enterAmount(Amount));
	}

	@Then("I click submit button")
	public void i_click_submit_button() {
		tf.clickSubmit();
	    

		
	    
	    
	}
	
	@When("amount unsuccesfully transfer")
	public void amount_unsuccesfully_transfer() {
		if (tf.sucessDisplay()) {
			String result="Error";
			String expectedResult=tf.validate_transfer_unsusscefull();
			sf.assertEquals(expectedResult, result);
		
		
		}
		else {
			
			boolean res=tf.sucessDisplay();
			sf.assertTrue(res);
		}
		
	}





}
