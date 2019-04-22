package com.fp.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ExcelUtils {

	// public static XSSFWorkBook wb;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;

	public void setPath(String testName) {
		String path = System.getProperty("user.dir") + "\\DataTable\\"+testName+"\\MyData.xlsx";
		// Read the excel
		try {
			// Load the file
			FileInputStream fs = new FileInputStream(path);

			// Load the workbook
			wb = new XSSFWorkbook(fs);

			// load sheet
			sh = wb.getSheetAt(0);

		}

		catch (Exception e) {
		}
	}

	public String getCellData(int rowNum, int colNum) {

		return sh.getRow(rowNum).getCell(colNum).getStringCellValue();

	}
}
