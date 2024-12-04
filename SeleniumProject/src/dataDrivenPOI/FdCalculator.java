package dataDrivenPOI;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FdCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id=\"wzrk-cancel\"]")).click();
		String filePath=System.getProperty("user.dir")+"\\WorkBookExcel\\calData.xlsx";
		String sheet="Sheet1";
		int rows=ExcelUtils.getRowCount(filePath, sheet);
		int cols=ExcelUtils.cellCount(filePath,sheet,0);
		System.out.println(cols);
		for(int i=1;i<=rows;i++) {
			String principal=ExcelUtils.getCellData(filePath, sheet, i, 0);
			String roi=ExcelUtils.getCellData(filePath, sheet, i, 1);
			String per1=ExcelUtils.getCellData(filePath, sheet, i, 2);
			String per2=ExcelUtils.getCellData(filePath, sheet, i, 3);
			String freq=ExcelUtils.getCellData(filePath, sheet, i, 4);
			String exp_Value=ExcelUtils.getCellData(filePath, sheet, i, 5);
			//pass same data into excel
			driver.findElement(By.xpath("//input[@id=\"principal\"]")).sendKeys(principal);
			driver.findElement(By.xpath("//input[@id=\"interest\"]")).sendKeys(roi);
			driver.findElement(By.xpath("//input[@id=\"tenure\"]")).sendKeys(per1);
			Thread.sleep(1000);
			WebElement tenurePeriod=driver.findElement(By.xpath("//*[@id=\"tenurePeriod\"]"));
			tenurePeriod.click();
			Select options=new Select(tenurePeriod);
			options.selectByVisibleText(per2);
			
			Select freqDrp=new Select(driver.findElement(By.xpath("//select[@id=\"frequency\"]")));
			freqDrp.selectByVisibleText(freq);			
			//calculate rate of intrest
			driver.findElement(By.xpath("//div[@class=\"CTR PT15\"]//a[1]")).click();
			String act_valu=driver.findElement(By.xpath("//*[@id=\"resp_matval\"]//strong")).getText();
			if(Double.parseDouble(exp_Value)==Double.parseDouble(act_valu)) {
				System.out.println("Test Case Passed");
				ExcelUtils.setCellData(filePath, sheet, i, cols-1, "Passed");
				ExcelUtils.fillGreenColor(filePath, sheet, i, cols-1, "Passed");
				System.out.println("Hello Mritunjau");
			}
			else {
				System.out.println("Test Case Failed");
				ExcelUtils.setCellData(filePath, sheet, i, 7, "Fail");
				ExcelUtils.fillRedColor(filePath, sheet, i, 7, "Fail");
			}
			driver.findElement(By.xpath("//div[@class=\"CTR PT15\"]//a[2]")).click();
			Thread.sleep(1000);
		}
		driver.quit();
	}

}
