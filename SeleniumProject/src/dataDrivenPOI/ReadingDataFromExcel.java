package dataDrivenPOI;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\WorkBookExcel\\DataProvider.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		int totalRow=sheet.getLastRowNum();
		int totalCells=sheet.getRow(0).getLastCellNum();
		System.out.println("Number of Rows "+totalRow);
		System.out.println("Number of columns :"+totalCells);
		for(int row=0;row<=totalRow;row++) {
			XSSFRow currentRow=sheet.getRow(row);											
			for(int col=0;col<totalCells;col++) {
				XSSFCell cell=currentRow.getCell(col);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}

		workbook.close();
		fs.close();
	}

}
