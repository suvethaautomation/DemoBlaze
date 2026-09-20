package genUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {

	public String toReadfromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream("./src\\test\\resources\\DemoBlazeSignUp_PlaceOrder.xlsx");
		Workbook work=WorkbookFactory.create(fis);	
		String data = work.getSheet(sheetname).getRow(rownum).getCell(cellnum).getStringCellValue();
		return data;
	}

}
