package Patrol.Test;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExtentReportBasic.ExtentReportManager;
import Patrol.Page.AddCase_HC_ByAdvocatePage;
import Patrol.Page.AddCase_HC_ByCasePage;
import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.UtilityClass;

public class AddCase_HC_ByAdvocateTest extends BaseTest {
	
	
	UtilityClass utility;
	String tcid;
	
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	@BeforeMethod
	public void initialize()
	{
	  extent=ExtentReportManager.getReports();
	  test= extent.createTest("Testing Add case module  : HC By Advocate"); 
		
	}
	
	@Test
	
	public void verifyByAdvocate() {
		
		LoginPage loginPage = new LoginPage(driver,test);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardPage = new DashBoardPage(driver,test);
		dashBoardPage.clickOncompany("Legitquest");
		
		AddCases_SC_ByDiaryNumberPage byDiaryNumber = new AddCases_SC_ByDiaryNumberPage(driver,test);
		byDiaryNumber.clickOnTotalcases();
		byDiaryNumber.clickOnAddCases();
		
		AddCase_HC_ByCasePage byCasePage = new AddCase_HC_ByCasePage(driver,test);
		byCasePage.clickOnHighCourt();
		
		AddCase_HC_ByAdvocatePage byAdvocateName = new AddCase_HC_ByAdvocatePage(driver,test);
		byAdvocateName.clickOnByAdvoacteName();
		byAdvocateName.selectCourt("High Court of Karnataka");
		byAdvocateName.enterAdvocateName("Patil");
		byAdvocateName.selectYear("2019");
		byAdvocateName.clickOnSearchCaseButton();
		byAdvocateName.selectCases(10);
		byAdvocateName.clickOnOkButton();
		
		
	}

	
	@AfterMethod()
	public void aftermethod(ITestResult result) throws  IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case is failed"+result.getName());
			test.log(Status.FAIL, "test case is failed"+result.getThrowable());
			String screenshot=  UtilityClass.Capaturescreenshot(driver,result.getName() );
		
			test.log(Status.FAIL,"test"+ test.addScreenCaptureFromPath(screenshot));
		
		}
		
		else if(result.getStatus()== ITestResult.SKIP){
			
			
			test.log(Status.SKIP, "test case is skipped"+result.getName());
			

		}extent.flush();
		driver.quit();	
		}
}
