package DDTPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DDTbyReadingDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
	
		FileInputStream fis = new FileInputStream("C:\\Users\\Heena\\eclipse-workspace\\Advance_Selenium\\src\\test\\resources\\TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String Campaign = wb.getSheet("Sheet1").getRow(1).getCell(2).getStringCellValue();
		double targetSize = wb.getSheet("Sheet1").getRow(0).getCell(2).getNumericCellValue();
		System.out.println(Campaign);
		System.out.println(targetSize);

	}

}
