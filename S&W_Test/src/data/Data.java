package data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data{

File src;
FileInputStream fis;
XSSFWorkbook wb;
XSSFSheet sheet;
int sheetNumber;
public Data(String sheetName){
	try {
	
	src = new File("D:\\Users\\franc\\Documents\\NYL Trainee Docs\\Score&Wod\\Data\\TestCasesValues.xlsx");
	fis = new FileInputStream(src);
	wb = new XSSFWorkbook(fis);
	sheetNumber = wb.getSheetIndex(sheetName);
	sheet = wb.getSheetAt(sheetNumber);
	
	}catch(Exception e) {
		e.printStackTrace();
	}
}

public ArrayList <String> getValues (String tid){
	//Omg i have no idea.
	return null;
}
}
