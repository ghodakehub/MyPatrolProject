package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCases_DC_ByCasePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_DC_ByCaseTest extends BaseTest {
	
	@Test
	
	public void verifyByCase() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOncompany("Skoda");
		
		AddCases_SC_ByDiaryNumberPage byDiaryNumber = new AddCases_SC_ByDiaryNumberPage(driver);
		byDiaryNumber.clickOnTotalcases();
		byDiaryNumber.clickOnAddCases();
		
		AddCases_DC_ByCasePage byCasePage = new AddCases_DC_ByCasePage(driver);
		byCasePage.clickOnDistrictCourts();
		byCasePage.selectState("Karnataka");
		byCasePage.selectDistrict("Bengaluru");
		byCasePage.selectForum("CHIEF METROPOLITAN MAGISTRATE COURT, BENGALURU");
		byCasePage.selectCaseType("C.C. - CRIMINAL CASES");
		byCasePage.enterCaseNo("2");
		byCasePage.selectYear("2023");
		byCasePage.clickOnsearchButton();
		byCasePage.clickOnCheckBox();
		byCasePage.clickOnAddCases();
		
	}

}
