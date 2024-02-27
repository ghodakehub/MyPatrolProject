package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCases_SC_ByAdvocateNamePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_SC_ByAdvocateNameTest extends BaseTest {
	
	@Test
	
	
	public void verifyAddCases_SC_ByAdvocateName() {
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
		
		AddCases_SC_ByAdvocateNamePage byAdvocateName = new AddCases_SC_ByAdvocateNamePage(driver);
		byAdvocateName.clickOnByAdvocateName();
		byAdvocateName.clickOnAdvocateOnRecord();
		byAdvocateName.enterAdvocateOnRecords("Aashish Gupta");
		
	}

}
