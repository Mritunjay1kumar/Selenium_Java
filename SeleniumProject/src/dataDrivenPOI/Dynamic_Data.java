package dataDrivenPOI;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dynamic_Data {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileOutputStream fs=new FileOutputStream(System.getProperty("user.dir")+"\\WorkBookExcel\\myFile_Dynamic.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("Data");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter How many rows:");
		int noOfRows=sc.nextInt();
		System.out.println("Enter How many cols:");
		int noOfCols=sc.nextInt();
		for(int r=0;r<=noOfRows;r++) {
			XSSFRow currentRow=sheet.createRow(r);
			for(int col=0;col<=noOfCols;col++) {
				String s=sc.next();
				currentRow.createCell(col).setCellValue(s);
			}
		}
		
		workbook.write(fs);
		workbook.close();
		fs.close();
	}

}
