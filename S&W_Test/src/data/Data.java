package data;

import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public abstract class Data {
	XSSFSheet sheet;

//This method will return every value matched with the id
	public abstract Object getValuesFromId(String tid);


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
