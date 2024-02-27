package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCase_HC_ByCNRnumber;
import Patrol.Page.AddCase_HC_ByCasePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_HC_ByCNRNumberTest extends BaseTest {

	@Test
	
	public void verifyAddCases_HC_ByCNRNumber() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOncompany("Skoda");
		
		AddCases_SC_ByDiaryNumberPage byDiaryNumber = new AddCases_SC_ByDiaryNumberPage(driver);
		byDiaryNumber.clickOnTotalcases();
		byDiaryNumber.clickOnAddCases();
		
		AddCase_HC_ByCasePage byCasePage = new AddCase_HC_ByCasePage(driver);
		byCasePage.clickOnHighCourt();
		
		AddCase_HC_ByCNRnumber byCNRNumber = new AddCase_HC_ByCNRnumber(driver);
		byCNRNumber.clickByCNRNumber();
		byCNRNumber.enterCNRNumber("UPHC011795402007");
		byCNRNumber.clickOnSearchForCase();
		byCNRNumber.clickOnCkeckBox();
		byCNRNumber.clickOnAddCases(); 
		
		
	}
	
	
	
}
