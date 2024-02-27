package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_SC_ByDiaryNumberTest extends BaseTest {
	
	@Test
	
	public void verifyAddCases_SC_ByDiaryNo() {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Skoda");
		
		AddCases_SC_ByDiaryNumberPage  byDiaryNumber = new AddCases_SC_ByDiaryNumberPage(driver);
		byDiaryNumber.clickOnTotalcases();
		byDiaryNumber.clickOnAddCases();
		byDiaryNumber.clickOnSupremeCourt();
		byDiaryNumber.enterDiaryNumber("1");
		byDiaryNumber.selectYear("2019");
		byDiaryNumber.performAction();
		byDiaryNumber.verifyAvailableCase();
		
		
		
		//byDiaryNumber.clickOnAddCasesButton();
		
		
	//	byDiaryNumber.verifyAvailableCase();
		
		
		//byDiaryNumber.clickOnCheckBox();
		//byDiaryNumber.clickOnAddCasesButton();
		
	}
	

	
	
		
	

}
