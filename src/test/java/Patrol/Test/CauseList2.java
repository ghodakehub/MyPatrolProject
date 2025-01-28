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
import Patrol.Page.CauseListPage;
import Patrol.Page.CheckDetailsOf_AddedFirm;
import Patrol.Page.DashBoardPage;
import Patrol.Page.Details_OfAddedFirm;
import Patrol.Page.LoginPage;
import Patrol.Page.causelistpage2;
import Patrol.Page.testcasuselsit;
import Patrol.Utility.BaseTest;
import Patrol.Utility.UtilityClass;

public class CauseList2 extends BaseTest {
	UtilityClass utility;
	String fileName;
	
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	@BeforeMethod
	public void initialize()
	{
	  extent=ExtentReportManager.getReports();
	  test= extent.createTest("Verify document module"); 
		
	}

	
	
@Test
	
	public void verifyCauseList() {
		
		LoginPage loginPage = new LoginPage(driver,test);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();

		//DashBoardPage dashBoardpage = new DashBoardPage(driver,test);
		//dashBoardpage.clickOncompany("Wipro");

		CheckDetailsOf_AddedFirm causeList = new CheckDetailsOf_AddedFirm(driver,test);
		causeList.CheckDetailsOF_Firm();
		//causelistpage2.captureScreenshot(driver, fileName);
	
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
