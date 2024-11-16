package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConditionalMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stubWebDriver driver;
		WebDriver driver;
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");
        driver.manage().window().maximize();
        WebElement logo=driver.findElement(By.xpath("//img[@alt=\"nopCommerce demo store\"]"));
        System.out.println("Display status of Logo is "+logo.isDisplayed());
        
        boolean enable=driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).isEnabled();
        System.out.println("first Name is enable : "+enable);
        WebElement male=driver.findElement(By.xpath("//*[@id=\"gender-male\"]"));
        WebElement female=driver.findElement(By.xpath("//*[@id=\"gender-female\"]"));
        male.click();
        System.out.println("male is selected: "+male.isSelected());
        System.out.println("female is selected: "+female.isSelected());

	}

}
