package mouseAction;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HoverAndClick {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.opencart.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Actions act=new Actions(driver);
        WebElement el1=driver.findElement(By.xpath("//li/a[contains(text(),'Desktops')]"));
        act.moveToElement(el1).build().perform();
        WebElement el2=driver.findElement(By.xpath("//a[text()='Mac (1)']"));
        act.moveToElement(el2).build();
        el2.click();
        

	}

}
