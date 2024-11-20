package CheckBox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckBox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //select specific check box
        //driver.findElement(By.xpath("//input[@id=\"sunday\"]")).click();
        
        //select all checkbox
        List<WebElement> ls=driver.findElements(By.xpath("//input[@class=\"form-check-input\" and @type=\"checkbox\" ]"));
        int i=0;
        for(WebElement x1:ls) {
        	if(i<4) {
        		i++;
        		continue;
        	}
        	x1.click();
        }
        
        for(WebElement x2:ls) {
        	if(x2.isSelected()) {
        		Thread.sleep(12);
        		x2.click();
        	}
        }
        
	}

}
