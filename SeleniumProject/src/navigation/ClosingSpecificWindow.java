package navigation;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClosingSpecificWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//*[text()='OrangeHRM, Inc']")).click();
        Set<String> windowId=driver.getWindowHandles();
        for(String winId:windowId) {
        	String title=driver.switchTo().window(winId).getTitle();
        	if(title.equalsIgnoreCase("OrangeHRM")) {
        		driver.close();
        	}
        }
        System.out.println("Finish");

	}

}
