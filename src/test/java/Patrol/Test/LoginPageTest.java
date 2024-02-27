package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class LoginPageTest extends BaseTest {
	
	@Test
	
	public void Verifyloginpage () {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.setEmail(Email);
		loginpage.setPassword(Password);
		loginpage.performAction();
	}

	
	
}
