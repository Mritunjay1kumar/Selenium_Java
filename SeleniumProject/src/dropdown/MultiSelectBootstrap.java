package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectBootstrap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[contains(@class,\"multiselect\")]")).click();
        List<WebElement> elementCount=driver.findElements(By.xpath("//ul[contains(@class,\"multiselect\")]//label"));
        System.out.println(elementCount.size());
        for(WebElement op:elementCount) {
        	if(op.isSelected()) {
        		continue;
        	}
        	else {
        		op.click();
        	}
        }

	}

}
