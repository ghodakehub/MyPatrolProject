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
import Patrol.Page.PeoplePage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.UtilityClass;

public class PeopleTest extends BaseTest{
	
	UtilityClass utility;
	String tcid;
	
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	@BeforeMethod
	public void initialize()
	{
	  extent=ExtentReportManager.getReports();
	  test= extent.createTest("verify Matter module"); 
		
	}

	@Test
	
	public void makeNewMatter() {
		
		LoginPage loginpage = new LoginPage(driver,test);
		loginpage.setEmail(Email);
		loginpage.setPassword(Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver,test);
		dashBoardpage.clickOncompany("Legitquest");
		
		PeoplePage people  = new PeoplePage(driver,test);
		people.ClickOnPeopleviewAll("NTPC_COMAPNY AutomationTest", "Company" ,"9678979089","Automation@gmail.com","Testing info for individual","Amravati");
		
		
		
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
