package dataDrivenPOI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteData {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fs=new FileOutputStream(System.getProperty("user.dir")+"\\WorkBookExcel\\myFile.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Data");
		XSSFRow row=sheet.createRow(0);
		row.createCell(0).setCellValue("Hindi");
		row.createCell(1).setCellValue("Price");
		XSSFRow row1=sheet.createRow(1);
		row1.createCell(0).setCellValue("English");
		row1.createCell(1).setCellValue("Mohit");
		XSSFRow row3=sheet.createRow(2);
		row3.createCell(0).setCellValue("Bhojpuri");
		row3.createCell(1).setCellValue(24.66);
		
		workbook.write(fs);
		System.out.println("Update File");
	}

}
