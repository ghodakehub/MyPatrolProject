package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCases_SelectForumPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_SelectForumTest extends BaseTest {
	
	@Test
	
	
	public void verifyForum() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Skoda");
		dashBoardpage.verifyText();
		
		
		AddCases_SelectForumPage forum = new AddCases_SelectForumPage(driver);
		forum.verifyCourts();
		
	}

}
