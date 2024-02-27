 package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.ActiveFirmPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class ActiveFirmTest extends BaseTest{
	
	@Test
	
	public void verifyActiveFirm() {
		LoginPage loginPage =new LoginPage(driver);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();
		
		ActiveFirmPage activeFirmpage = new ActiveFirmPage(driver);
		activeFirmpage.verifyText();
		
		
		
		
	}
	
	

}
