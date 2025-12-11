package DataDriven_Test;

import java.io.FileInputStream;
import java.io.IOException;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import GenericUtility.ExcelUtility;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		ExcelUtility elib=new ExcelUtility();// reading data from excel utility
		String value = elib.toReadDataFromExcelFile("Sheet1", 1, 1);
		String value1 = elib.toReadDataFromExcelFile("Sheet1", 1, 2);
		
		
		System.out.println(value1);
		
		int count = elib.togetLastRowNum("Sheet2");
		
		
		
		for(int i=1;i<=count;i++) {
			String value2 = elib.toReadDataFromExcelFile("Sheet2", i, 0);
			//String value2 = sheet2.getRow(i).getCell(0).getStringCellValue();
			System.out.println(value2);
		}
		
	}

}
