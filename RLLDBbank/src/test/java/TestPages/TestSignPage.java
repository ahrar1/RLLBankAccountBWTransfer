package TestPages;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.POMSignIn;
import pages.TestBase;

public class TestSignPage extends TestBase{
	
	POMSignIn ps;
	@BeforeTest
	public void setup() {
		getBrowser();
		ps = new POMSignIn(driver);
	}
	
	@Test
	public void getLogin() {
		ps.signPage();
	}

}
