package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
/*
 * open Application
 * test logo is present
 * login
 * close
 */

public class orangeHRMTest {
	WebDriver driver;
	
	@Test(priority=1)
	void openApplication() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		
	}
	@Test(priority=2)
	void testLogo() throws Exception {
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		boolean status=driver.findElement(By.xpath("//img[@alt=\"company-branding\"]")).isDisplayed();
		System.out.println("status is:"+status);
	}
	@Test(priority=3)
	void testLogin() {
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name=\"password\"]")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
	}
	@Test(priority=4)
	void close() {
		driver.quit();
		
	}
  
}
