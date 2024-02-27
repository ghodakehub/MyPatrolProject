package Patrol.Test;

import org.testng.annotations.Test;

import Patrol.Page.AddCases_SC_ByCaseTypePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_SC_ByCaseTypeTest extends BaseTest {

	@Test

	public void verifyAddCases_SC_ByCaseType() {

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

		AddCases_SC_ByCaseTypePage byCaseType2 = new AddCases_SC_ByCaseTypePage(driver);
		byCaseType2.clickOnByCaseType();
		byCaseType2.selectCasetype("WRIT PETITION (CIVIL)");
		byCaseType2.enterCaseNo("10");
		byCaseType2.selectYear2("1985");
		byCaseType2.performAction2();
		byCaseType2.verifyAvailableCases();
		
		
	}

}
