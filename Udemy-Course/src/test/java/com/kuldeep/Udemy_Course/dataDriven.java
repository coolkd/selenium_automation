package com.kuldeep.Udemy_Course;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {

	public static void main(String[] args) throws IOException {
		// identify Testcase coloumn by scanning the entire 1st row

		// once coloumn is identified then scan entire testcase coloumn to identify
		// Appium test case row

		// after we grab purchase testcase row = pull all the data of that row and feed
		// into test

		// fileInputStream argument
		ArrayList<String> a =new ArrayList<String>();

		FileInputStream fis = new FileInputStream("/home/kuldeep/testData.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {

			if (workbook.getSheetName(i).equalsIgnoreCase("TestSheet1"))
				;

			HSSFSheet sheet = workbook.getSheetAt(i);

			// identify Testcase coloumn by scanning the entire 1st row
			sheet.iterator();
			Iterator<Row> rows = sheet.iterator();// sheet is collection of rows
			Row firstrow = rows.next();
			Iterator<Cell> ce = firstrow.cellIterator();// row is collection of cells
			int k = 0;
			int coloumn = 0;

			while (ce.hasNext()) {
				Cell value = ce.next();
				if (value.getStringCellValue().equalsIgnoreCase("Case3")) {
					// desired coloumn

					coloumn = k;

				}
				k++;
			}
			System.out.println(coloumn);
			// once coloumn is identified then scan entire testcase coloumn to identify
			// Appium test case row

			while (rows.hasNext()) {

				Row r = rows.next();
				if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Appium")) {

					// after we grab purchase testcase row = pull all the data of that row and feed
					// into test

					Iterator<Cell> cv = r.cellIterator();
					while (cv.hasNext()) {
						a.add(cv.next().getStringCellValue());
					}

				}

			}
		}

	}

}
