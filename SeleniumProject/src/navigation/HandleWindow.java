package navigation;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String titleParent=driver.getTitle();
        driver.findElement(By.xpath("//*[text()='OrangeHRM, Inc']")).click();
        Set<String> windowId=driver.getWindowHandles();
        List<String> listWindowId=new ArrayList(windowId);
        String parentId=listWindowId.get(0);
        String childId=listWindowId.get(1);
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(childId);
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(parentId);
        System.out.println(driver.getCurrentUrl());

	}

}
