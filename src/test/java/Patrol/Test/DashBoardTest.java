package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class DashBoardTest extends BaseTest{
	
	@Test
	
	public void verifyDashBoard() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Skoda");
		dashBoardpage.verifyText();
		
		
		
		
	}

}
