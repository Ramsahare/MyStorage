package Flipkart.genericUtility;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * its developed using Apache POi libraries , which used to handle Microsoft
 * Excel sheet
 * 
 * @author Rameshwar
 *
 */
public class ExcelUtility {
	/**
	 * its used read the data from excel based on below arguments
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @return Data
	 * @throws Throwable
	 */
	public String getDataFromExcel(String sheetname, int rownum, int cellnum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/flip/Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		String data = row.getCell(cellnum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * used to get the last used row number on specified Sheet
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/orgTestData/createConwithOrg.xlsx");
		Workbook wb1 = WorkbookFactory.create(fis);
		Sheet sh = wb1.getSheet(sheetName);
		wb1.close();
		return sh.getLastRowNum();
	}
	public void setDataExcel(String sheetName, int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/orgTestData/createConwithOrg.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		Row row = sh.getRow(rowNum);
		Cell cel = row.createCell(celNum);
		cel.setCellValue(data);
		FileOutputStream fos = new FileOutputStream("./src/test/resources/orgTestData/createConwithOrg.xlsx");
		wb.write(fos);
		wb.close();
	}
}
