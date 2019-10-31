package data.ObjectMethods;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import data.Data;
import data.Objects.Login;

public class LoginDataMethods extends Data{
	
	XSSFSheet sheet;
	File src;
	FileInputStream fis;
	XSSFWorkbook wb;
	int sheetNumber;
	Login login;

	public LoginDataMethods(String sheetName, String fileName) {
		try {
			src = new File(fileName);
			fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
			sheetNumber = wb.getSheetIndex(sheetName);
			sheet = wb.getSheetAt(sheetNumber);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public Object getValuesFromId(String tid) {
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

}
