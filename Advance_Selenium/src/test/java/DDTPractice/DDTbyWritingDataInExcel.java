package DDTPractice;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTbyWritingDataInExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		  FileInputStream fis = new FileInputStream("C:\\Users\\Heena\\eclipse-workspace\\Advance_Selenium\\src\\test\\resources\\TestScriptData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
		    wb.createSheet("WriteData").createRow(1).createCell(2).setCellValue("Selenium");
		    
		    FileOutputStream fos = new FileOutputStream("C:\\Users\\Heena\\eclipse-workspace\\Advance_Selenium\\src\\test\\resources\\TestScriptData.xlsx");
            wb.write(fos);
            wb.close();
	}

}
