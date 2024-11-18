package selenium;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        WebDriverWait myWait=new WebDriverWait(driver, Duration.ofSeconds(7));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
//        Thread.sleep(3000);
        WebElement txtuser=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"username\"]")));
        txtuser.sendKeys("Admin");
        WebElement txtPass=myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name=\"password\"]")));
        txtPass.sendKeys("admin123");
        WebElement clickable=myWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@type=\"submit\"]")));
        clickable.click();
	}

}
