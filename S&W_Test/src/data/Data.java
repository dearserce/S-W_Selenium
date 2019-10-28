package data;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import data.Objects.Login;

public class Data {

	File src;
	FileInputStream fis;
	XSSFWorkbook wb;
	XSSFSheet sheet;
	int sheetNumber;
	Login login;

	public Data(String sheetName) {
		try {

			src = new File("D:\\Users\\franc\\Documents\\NYL Trainee Docs\\Score&Wod\\Data\\TestCasesValues.xlsx");
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			sheetNumber = wb.getSheetIndex(sheetName);
			sheet = wb.getSheetAt(sheetNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//This method will return every value matched with the id
	public Login getValuesFromId(String tid) {
		login = new Login(tid);
		try {
			// Find number of rows getLastRowNum return the number of rows starting from 0
			int rowCount = sheet.getLastRowNum() + 1;
			// Create a loop over all the rows to read everything
			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				// Loop to Save everything
				for (int j = 0; j < row.getLastCellNum(); j++) {
					if (row.getCell(0).getStringCellValue().equals(tid)) {
						//Now we have we are under the correct TID
						//we should parse everything well.
						login.setTestCase(row.getCell(1).getStringCellValue());
						login.setUsername(row.getCell(2).getStringCellValue());
						login.setPassword(row.getCell(3).getStringCellValue());
						login.setRememberMe(row.getCell(4).getStringCellValue());
						login.setExpectedResult(row.getCell(5).getStringCellValue());
					}
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem while getting values");
		}
		return login;
	}

//This method will return every value in the file
	public ArrayList<String> getAllValues() {
		ArrayList<String> allValues = new ArrayList<String>();
		try {
			// Find number of rows getLastRowNum return the number of rows starting from 0
			int rowCount = sheet.getLastRowNum() + 1;
			System.out.println(rowCount);
			// Create a loop over all the rows to read everything
			for (int i = 0; i < rowCount; i++) {
				Row row = sheet.getRow(i);
				// Loop to print everything
				for (int j = 0; j < row.getLastCellNum(); j++) {
					allValues.add(row.getCell(j).getStringCellValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Problem while getting values");
		}
		return allValues;
	}
}
