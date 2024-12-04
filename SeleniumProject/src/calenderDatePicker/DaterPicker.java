package calenderDatePicker;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DaterPicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//https://jqueryui.com/datepicker/
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement frame=driver.findElement(By.xpath("//iframe[@class=\"demo-frame\"]"));
        driver.switchTo().frame(frame);
        
        /*1--using send keys
        driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).sendKeys("12/03/1999");
        
        */
        //Date Picker
        String year="2025";
        String month="May";
        String date="20";
        
        driver.findElement(By.xpath("//input[@id=\"datepicker\"]")).click();
        int cnt=0;
        while(true) {
        	String currentMnth=driver.findElement(By.xpath("//*[@class=\"ui-datepicker-month\"]")).getText();
        	String currentYear=driver.findElement(By.xpath("//*[@class=\"ui-datepicker-year\"]")).getText();
        	if(currentMnth.equals(month)&& currentYear.equals(year)) {
        		break;
        	}
        	driver.findElement(By.xpath("//*[@title=\"Next\"]")).click();
        	cnt++;
        }
        System.out.println(cnt);
        List<WebElement> dates=driver.findElements(By.xpath("//table[@class=\"ui-datepicker-calendar\"]//tbody//tr//td//a"));
        for(WebElement dat1:dates) {
        	if(dat1.getText().equals(date)) {
        		dat1.click();
        		break;
        	}
        }
	}

}
