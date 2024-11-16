package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CromeLaunch {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        Thread.sleep(5000);
        driver.findElement(By.linkText("OrangeHRM, Inc")).click();
        
        //System.out.println(driver.getPageSource());
//        System.out.println(driver.getWindowHandle());
        Set<String> windowId=driver.getWindowHandles();
        System.out.println(windowId);
        for(String s:windowId) {
        	System.out.println(s);
        }
        
	}

}
