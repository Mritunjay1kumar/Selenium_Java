package table;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicPage {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//		https://www.ecomdeveloper.com/demo/admin/index.php
//			User: demoadmin 
//			Password: demopass
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement userName=driver.findElement(By.xpath("//input[@name=\"username\"]"));
        Thread.sleep(2000);
        userName.clear();
        userName.sendKeys("demoadmin");
        WebElement passWord=driver.findElement(By.xpath("//input[@name=\"password\"]"));
        passWord.clear();
        passWord.sendKeys("demopass");
        driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@class=\"parent collapsed\"][normalize-space()=\"Customers\"]")).click();
        driver.findElement(By.xpath("//ul[@class=\"collapse in\"]//a")).click();
        String text=driver.findElement(By.xpath("//*[contains(text(),'Showing')]")).getText();
        int startIndex = text.indexOf("of ") + 3; // Find "of " and move past it
        int endIndex = text.indexOf(" ", startIndex); // Find the next space after the number
        int number = Integer.parseInt(text.substring(startIndex, endIndex));
        System.out.println(number);
        for(int i=1;i<=5;i++) {
        	if(number>1) {
        		WebElement active_page=driver.findElement(By.xpath("//ul[@class=\"pagination\"]//*[text()="+i+"]"));
        		active_page.click();
        		}
        	int row=driver.findElements(By.xpath("//table[contains(@class,\"table-hover\")]//tbody//tr")).size();
        	for(int j=1;j<=row;j++) {
        		String customerName=driver.findElement(By.xpath("//table[contains(@class,\"table-hover\")]//tbody//tr["+j+"]//td[2]")).getText();
        		String email=driver.findElement(By.xpath("//table[contains(@class,\"table-hover\")]//tbody//tr["+j+"]//td[3]")).getText();
        		System.out.println(customerName+"\t\t"+email);
        	}
        	
        }
        
	}

}
