package DataDriven_Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingthedatabacktoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("C:\\Users\\Administrator\\Desktop\\java selenium\\AdvanceJavaAutomation\\src\\test\\resources\\e35.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet6");
		// Row crt_row = sh.createRow(2);
		Row row = sh.getRow(2);
		Cell cel = row.createCell(0);
		cel.setCellValue("maven");
		FileOutputStream fos = new FileOutputStream("C:\\Users\\Administrator\\Desktop\\java selenium\\AdvanceJavaAutomation\\src\\test\\resources\\e35.xlsx");
		wb.write(fos);
		wb.close();
		

	}

}
