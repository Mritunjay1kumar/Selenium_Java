package table;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StaticTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int tr=driver.findElements(By.xpath("//table[@name=\"BookTable\"]//tr")).size();
        
        //no of column in table
        int col=driver.findElements(By.xpath("(//table[@name=\"BookTable\"]//tr)[1]/th")).size();
        System.out.println("Colummn in table: "+col);
        String bookName=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[5]//td[1]")).getText();
        System.out.println(bookName);
        String course=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr[7]//td[3]")).getText();
        System.out.println(course);
        for(int r=2;r<=tr;r++) {
        	for(int c=1;c<=col;c++) {
        		String s=driver.findElement(By.xpath("//table[@name=\"BookTable\"]//tr["+r+"]//td["+c+"]")).getText();
        		System.out.print(s+"\t");
        	}
        	System.out.println();
        }

	}

}
