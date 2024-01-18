package TestPages;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.POMSignIn;
import pages.TransferBwAccounts;
import pages.TestBase;

public class TestTransferBetAccountPage extends TestBase{
	POMSignIn ps;
	TransferBwAccounts pt;
	@BeforeTest
	public void setup() {
		getBrowser();
		ps = new POMSignIn(driver);
		pt=new TransferBwAccounts(driver);
	}
	

	@Test(priority='1')
	public void getLogin() {
		ps.signPage();
	}

	@Test(priority='2')
	public void clickTransferBtn() {
		pt.transferMoney();
	}

	@Test(priority='3')
	public void chooseFromAccount() {
		pt.clickFrom();
	}

	@Test(priority='4')
	public void chooseToAccount() {
		pt.clickTo();
	}

	@Test(priority='5')
	public void enterMoney(String money) {
		pt.enterAmount(money);
	}
	

	@Test(priority='6')
	public void submitDone() {
		pt.clickSubmit();
		
		if (pt.sucessDisplay()) {
			String result="View Savings Accounts";
			String expectedResult=pt.validate_transfer_sussceful();
		assertEquals(expectedResult, result);
		
		}
		else {
			String result="Error";
			String expectedResult=pt.validate_transfer_unsusscefull();
			assertEquals(expectedResult, result);
		}
	}
}
