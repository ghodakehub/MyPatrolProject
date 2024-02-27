package Patrol.Test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Patrol.Page.AddCases_SC_ByDiaryNumberPage;
import Patrol.Page.AddCases_Tribunal_ByCasePage;
import Patrol.Page.DashBoardPage;
import Patrol.Page.LoginPage;
import Patrol.Utility.BaseTest;

public class AddCases_Tribunal_ByCaseTest extends BaseTest{

	
//	@DataProvider(name = "excelData")
//	public Object[][] testExcel() throws IOException {
//
//		String filepath = System.getProperty("user.dir") + "\\TestData\\Data.xlsx";
////		String filepath = System.getProperty("user.dir") + "\\TestData\\YTP_Reprice.xlsx";
//		FileInputStream fis = new FileInputStream(filepath);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheet("YTP");
//		int rowCount = sheet.getLastRowNum();
//		int colCount = 63;
//		Object[][] dataObj = new Object[rowCount][colCount];
//
//		for (int i = 1; i <= rowCount; i++) {
//			Row row = sheet.getRow(i);
//			for (int j = 0; j < colCount; j++) {
//				int rowNum = i;
//				rowNum--;
//				dataObj[rowNum][j] = row.getCell(j).toString();
//			}
//		}
//		return dataObj;
//	}
//	
	
	@Test
	
	public void verifyTribunals() {
		
		LoginPage loginPage = new LoginPage(driver);
		loginPage.setEmail(Email);
		loginPage.setPassword(Password);
		loginPage.performAction();
		
		DashBoardPage dashBoardPage = new DashBoardPage(driver);
		dashBoardPage.clickOncompany("Skoda");
		
		AddCases_SC_ByDiaryNumberPage byDiaryNumber = new AddCases_SC_ByDiaryNumberPage(driver);
		byDiaryNumber.clickOnTotalcases();
		byDiaryNumber.clickOnAddCases();
		
		
		AddCases_Tribunal_ByCasePage byCase = new AddCases_Tribunal_ByCasePage(driver);
		byCase.clickOnTribunals();
		byCase.selectCourt("CAT");
		byCase.selectYear("2015");
		byCase.enterPartyName("State");
		byCase.clickOnSearchButton();
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
