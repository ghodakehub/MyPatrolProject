package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCase_HC_ByCasePage;
import Patrol.Page.AddCase_HC_ByPartyNamePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCase_HC_ByPartyNameTest extends BaseTest {
	
	@Test
	
	public void verifyAddCase_HC_ByPartyName () {
		
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
		
		
		AddCase_HC_ByPartyNamePage byPartyName = new AddCase_HC_ByPartyNamePage(driver);
		byPartyName.clickOnPartyName();
		byPartyName.selectCourt("Bombay High Court");
		byPartyName.selectCaseStatus("All");
		byPartyName.selectYear("2015");
		byPartyName.enterPartyName("Patil");
		byPartyName.clickOnSearchForCase();
		byPartyName.selectCases(10);
		byPartyName.clickOnOkButton();
		
		
	}

}
