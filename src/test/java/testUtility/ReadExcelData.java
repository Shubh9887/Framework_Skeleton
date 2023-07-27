package testUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadExcelData {

	public static String fetchExcelData(int row, int cell, String fileName, String sheetName) throws EncryptedDocumentException, IOException {
		String data = ""; 
		String path = "src" + File.separator + "test" + File.separator +"resources" + File.separator + "TestData" +File.separator + fileName + ".xlsx";
		FileInputStream file = new FileInputStream(path);
		
		Cell c = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell);
		CellType type = c.getCellType();
		
		if(type==CellType.STRING) {
			data=c.getStringCellValue();
		}
		else if (type==CellType.NUMERIC) {
			double number = c.getNumericCellValue();
			data = Double.toString(number);
		}
		else if (type== CellType.BLANK) {
			data = "";
		}
		
		return data;
		
	}
}
