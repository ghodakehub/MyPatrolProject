package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCase_HC_ByCasePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_HC_ByCaseTest extends BaseTest {

	@Test
	
	public void verifyAddCases_HC_ByCase() {
		
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
		byCasePage.selectCourt("High Court of Karnataka");
		byCasePage.selectBench("Principal Bench at Bengaluru");
		byCasePage.selectCaseType("WP(Writ Petition)-144");
		byCasePage.enterCaseNo("1");
		byCasePage.selectYear("2013");
		byCasePage.clickOnSearchForCase();
		byCasePage.clickOnCheckBox();
		byCasePage.clickOnAddCases();
		byCasePage.clickOnOkButton();		
		
		
		
	}
	
	
	
}
