package day1;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream(
				"C:\\Users\\PUSHPA\\Documents\\Testing program\\SeleniumWebDriver\\testdata\\salaries.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		int totalrows = sheet.getLastRowNum();
		int totalcolumns = sheet.getRow(1).getLastCellNum();
		System.out.println("Total no of rows ===> " + totalrows);
		System.out.println("Total no of columns ===> " + totalcolumns);

		for (int r = 0; r <= totalrows; r++) {
			XSSFRow currentrow = sheet.getRow(r);
			for (int c = 0; c < totalcolumns; c++) {
				XSSFCell cell = currentrow.getCell(c);
				System.out.print(cell.toString() + "\t");

			}
			System.out.println();
		}
		workbook.close();
		file.close();
	}

}
