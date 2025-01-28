package Patrol.Test;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import ExtentReportBasic.ExtentReportManager;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Page.Notification_Page;
import Patrol.Utility.BaseTest;
import Patrol.Utility.UtilityClass;

public class Notification_Test extends BaseTest {
	

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
	
	public void verifyNotification() {
		
		LoginPage loginPage = new LoginPage(driver,test);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();

		DashBoardPage dashBoardpage = new DashBoardPage(driver,test);
		dashBoardpage.clickOncompany("Skodayuu");
		
		Notification_Page nofificationPage = new Notification_Page(driver,test);
		nofificationPage.clickOnNotification();
		nofificationPage.verifyNotificationBarElement();
		
		
	}
	
	@AfterMethod()
	public void aftermethod(ITestResult result) throws  IOException
	{
		if(result.getStatus()== ITestResult.FAILURE)
		{
			test.log(Status.FAIL, "test case is failed"+result.getName());
			test.log(Status.FAIL, "test case is failed"+result.getThrowable());
			UtilityClass.Capaturescreenshot(driver, UtilityClass.Capaturescreenshot(driver,screenshot ));
			test.log(Status.FAIL, (Markup) test.addScreenCaptureFromPath(screenshot));
		
		}
		
		else if(result.getStatus()== ITestResult.SKIP){
			
			
			test.log(Status.FAIL, "test case is skipped"+result.getName());
			

		}extent.flush();
	driver.quit();	
		}

}
