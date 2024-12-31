package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Constants.ConstantValues;

public class ExcelUtility {
	
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	
public static String getStringData(int row,int col, String filepath,String sheetName) throws IOException {
		
	
	
		f= new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}



public static String getIntegerData(int row,int col,String filepath, String sheetName) throws IOException {
		
	
	
		f= new FileInputStream(filepath);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheetName);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		int val=(int)c.getNumericCellValue();
		return String.valueOf(val);
	}

}
