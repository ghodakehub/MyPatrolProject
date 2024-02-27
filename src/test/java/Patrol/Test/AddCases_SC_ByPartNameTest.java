package Patrol.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.AddCases_SC_ByPartyNamePage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_SC_ByPartNameTest extends BaseTest{
	
	@Test
	
	public void verifyAddCase_SC_ByPartyType() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver);
		dashBoardpage.clickOncompany("Skoda");

		AddCases_SC_ByDiaryNumberPage byCaseType = new AddCases_SC_ByDiaryNumberPage(driver);
		byCaseType.clickOnTotalcases();
		byCaseType.clickOnAddCases();
		byCaseType.clickOnSupremeCourt();
		
		AddCases_SC_ByPartyNamePage byPartyType = new AddCases_SC_ByPartyNamePage(driver);
		byPartyType.clickOnPatyName();
		byPartyType.enterValueOnPartyNameTab("wkjfiwrbeibevivberobei");
		byPartyType.selectYear("1925");
		byPartyType.clickOnSearchCases();
		byPartyType.selectCases(10);
		
	}

}
