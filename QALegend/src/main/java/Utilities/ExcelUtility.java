package Utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	static FileInputStream f;
	static XSSFWorkbook w;
	static XSSFSheet sh;
	
public static String getData(int row,int col, String sheet) throws IOException {
		
		f= new FileInputStream("C:\\Users\\hp\\OneDrive\\Desktop\\Book1.xlsx");
		w = new XSSFWorkbook(f);
		sh = w.getSheet("Sheet1");
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);
		return c.getStringCellValue();
	}

}
