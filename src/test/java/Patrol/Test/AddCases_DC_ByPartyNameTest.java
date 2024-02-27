package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCases_DC_ByCasePage;
import Patrol.Page.AddCases_DC_ByPartyNamePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_DC_ByPartyNameTest extends BaseTest{

	@Test
	
	public void verifyByPartyName() {
		
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
		
		AddCases_DC_ByPartyNamePage byPartyName = new AddCases_DC_ByPartyNamePage(driver);
		byPartyName.clickOnByPartyName();
		byPartyName.selectState("Maharashtra");
		byPartyName.selectDistrict("Kolhapur");
		byPartyName.selectCaseStatus("All");
		byPartyName.selectYear("2015");
		byPartyName.enterPartyName("Patil");
		byPartyName.clickOnSearch();
		byPartyName.selectCasesByCheckBox(10);
		byPartyName.clickOnOkButton();
		
		
		
	}
	
	
}
