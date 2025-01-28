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
import Patrol.Page.MatterDetailsPage;
import Patrol.Utility.BaseTest;
import Patrol.Utility.UtilityClass;

public class MatterDetailsTest extends BaseTest {
	
	
	
	UtilityClass utility;
	String tcid;
	
	
	public static ExtentReports extent;
	
	public static ExtentSparkReporter spark;
	
	public static ExtentTest test;
	
	
	@BeforeMethod
	public void initialize()
	{
	  extent=ExtentReportManager.getReports();
	  test= extent.createTest("Verify createTask on Matter details page"); 
		
	}

	@Test
	
	public void makeNewMatterforHC() {
		
		LoginPage loginpage = new LoginPage(driver,test);
		loginpage.setEmail(Email);
		loginpage.setPassword(Password);
		loginpage.performAction();
		
		DashBoardPage dashBoardpage = new DashBoardPage(driver,test);
		dashBoardpage.clickOncompany("Legitquest");
		
		MatterDetailsPage matterPage1 = new MatterDetailsPage(driver,test);
		matterPage1.clickOnMatterViewAll();
		
		matterPage1.ClickonTask("pratiksha shinde","Pending");
		
		
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
