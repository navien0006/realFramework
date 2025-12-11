package GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility {
	public String toReadDataFromExcelFile(String sheetname, int rownum, int cellnum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\e35.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		String value = sh.getRow(rownum).getCell(cellnum).getStringCellValue();
		return value;
		
	}
	
	public int togetLastRowNum(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\e35.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rownum = sh.getLastRowNum();
		return rownum;
		
	}

}
