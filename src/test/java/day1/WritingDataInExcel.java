package day1;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataInExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\testdata\\test.xlsx");

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("mydata");
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Viswakanth");
		row1.createCell(1).setCellValue("Prathibha");
		row1.createCell(2).setCellValue("Sri Chaitanya");
		row1.createCell(3).setCellValue("Sasi ");
		row1.createCell(4).setCellValue("Tadepalligudem");

		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("ManoJ");
		row2.createCell(1).setCellValue("Navodaya");
		row2.createCell(2).setCellValue("Narayana");
		row2.createCell(3).setCellValue("Pragathi ");
		row2.createCell(4).setCellValue("Peddapuram");

		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Rajesh");
		row3.createCell(1).setCellValue("Prathibha");
		row3.createCell(2).setCellValue("Gudivada");
		row3.createCell(3).setCellValue("Viswanatha ");
		row3.createCell(4).setCellValue("Vizag");

		XSSFRow row4 = sheet.createRow(3);
		row4.createCell(0).setCellValue("Bhargav");
		row4.createCell(1).setCellValue("Bhashyam");
		row4.createCell(2).setCellValue("Sri Chaitanya");
		row4.createCell(3).setCellValue("Amritha ");
		row4.createCell(4).setCellValue("Kollam");
		
		

		workbook.write(file);
		workbook.close();
		file.close();

	}

}
