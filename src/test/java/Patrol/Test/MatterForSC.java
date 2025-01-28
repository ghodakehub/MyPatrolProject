package Patrol.Test;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExtentReportBasic.ExtentReportManager;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.MatterPage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.UtilityClass;

public class MatterForSC extends BaseTest {

	UtilityClass utility;
	String tcid;
	
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	@BeforeMethod
	public void initialize()
	{
	  extent=ExtentReportManager.getReports();
	  test= extent.createTest("verify created matter for supremecourt"); 
		
	}

	@Test
	
	public void makeNewMatterforsc() {
		
		LoginPage loginpage = new LoginPage(driver,test);
		loginpage.setEmail(Email);
		loginpage.setPassword(Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver,test);
		dashBoardpage.clickOncompany("Legitquest");
		
		MatterPage matterPage = new MatterPage(driver,test);
		matterPage.clickOnMatterViewAll();
		matterPage.verifyTaskBarOfMatters();
		matterPage.clickOnNewMatterButton();
		matterPage.selectCourt("Supreme Court");
		matterPage.selectSearchCaseDropDown("LT. COL. D. K. HAVANOOR (RETD.) vs. UNION OF INDIA");
		matterPage.clickOnYesChangeButton();
		matterPage.clickOnNextButton();
		matterPage.selecpeople("Hashreen");
		matterPage.selectOrganisation("test2");
		matterPage.selectpracticearea("Family");
		matterPage.selecassinguser("pratiksha shinde");
		matterPage.selectdept("production department");
		matterPage.enterdata();
		matterPage.enterstatus("Open");
		matterPage.clickbtn("Hourly");
		
		
		
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
