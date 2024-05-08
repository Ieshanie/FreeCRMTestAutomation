package com.crm.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {

	public TestUtil(WebDriver driver) {
		this.driver = driver;
	}

	public static long PAGE_LOAD_TIMEOUT = 60;
	public static long IMPLICIT_WAIT = 60;
	static Workbook book;
	static Sheet sheet;
	public static String TESTDATA_SHEET_PATH = "C:/workspaces/SeleniumProjects/FreeCRMTest/src/main/java/com/crm/qa/testdata/FreeCRMTestData.xlsx";


	public void swithToFrame() {
		driver.switchTo().frame("mainpanel");
	}

	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			book = WorkbookFactory.create(file);
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sheet = book.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		int lastCellNum = sheet.getRow(0).getLastCellNum();

		System.out.println("Last Row Number: " + lastRowNum);
		System.out.println("Last Cell Number: " + lastCellNum);

		Object[][] data = new Object[lastRowNum][lastCellNum];

		for (int i = 0; i < lastRowNum; i++) {
			for (int k = 0; k < lastCellNum; k++) {
				data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
			}
		}
		return data;
	}
}
