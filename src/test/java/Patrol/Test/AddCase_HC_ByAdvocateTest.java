package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCase_HC_ByAdvocatePage;
import Patrol.Page.AddCase_HC_ByCasePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCase_HC_ByAdvocateTest extends BaseTest {
	
	@Test
	
	public void verifyByAdvocate() {
		
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
		
		AddCase_HC_ByAdvocatePage byAdvocateName = new AddCase_HC_ByAdvocatePage(driver);
		byAdvocateName.clickOnByAdvoacteName();
		byAdvocateName.selectCourt("High Court of Karnataka");
		byAdvocateName.enterAdvocateName("Patil");
		byAdvocateName.selectYear("2019");
		byAdvocateName.clickOnSearchCaseButton();
		byAdvocateName.selectCases(10);
		byAdvocateName.clickOnOkButton();
		
		
	}

}
