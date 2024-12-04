package shadowDOM;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowELement {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://books-pwakit.appspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      
		//This Element is inside 2 nested shadow DOM.
		String cssSelectorForHost1 = "book-app[apptitle='BOOKS']";
		String cssSelectorForHost2 = "book-input-decorator";
		Thread.sleep(1000);
		SearchContext shadow0 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		Thread.sleep(1000);
//		SearchContext shadow1 = shadow0.findElement(By.cssSelector("book-input-decorator")).getShadowRoot();
//		Thread.sleep(1000);
		shadow0.findElement(By.cssSelector("#input")).sendKeys("Welcome");

	}

}
