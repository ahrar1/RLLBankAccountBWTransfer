package stepdef;

import java.util.ArrayList;
import java.util.List;

import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.POMSignIn;
import pages.TestBase;
import pages.TransferBwAccounts;

public class TransferPage extends TestBase{
	
	POMSignIn sg;
	TransferBwAccounts tf ;
	SoftAssert sf = new SoftAssert();
	
	@Given("I am on signin page")
	public void i_am_on_signin_page() {
		
			
			 try {
				 getBrowser();
				 sg=new POMSignIn(driver);
				 tf=new  TransferBwAccounts(driver);
			 }
			 catch(Exception e) {
				 sf.fail("Unable to open browser");
			 }
			
			
		}
	

	@Given("i will sign in with valid credentials")
	public void i_will_sign_in_with_valid_credentials() {
		sg.signPage();
	}

	@When("i click on  the  transfer amount page")
	public void i_click_on_the_transfer_amount_page() {
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
	 ArrayList<String> myList = new ArrayList<>();
	@Then("I enter amount  on the page")
	public void i_enter_amount_on_the_page(io.cucumber.datatable.DataTable dataTable) {
		List<String> names = dataTable.asList(String.class);
		
		for (String name : names) {
			sf.assertTrue(tf.enterAmount(name));
			tf.clickSubmit();
			myList.add(tf.validate_transfer_sussceful());
			tf.transferMoney();
			tf.clickFrom() ;
			tf.clickTo();
        }
	   
	}


	
	
	@Then("I click reset button")
	public void i_click_reset_button() {
		
		tf.clickrest();
		sf.assertFalse(tf.deselected());
		System.out.println("deslected");
		
		
		
	}
	
	@And("Validate or not")
	public void Validate_or_not() {
		for (String res: myList) {
			//System.out.println(res);
			if(res=="View Savings Accounts")
			{
                String exp="View Savings Accounts";
				sf.assertEquals(res, exp);
			}
			else if(res=="Internal Transfer") {
				String exp2="Internal Transfer";
				sf.assertEquals(res, exp2);
			}
		}
	}


}
