package CheckBox;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
        Thread.sleep(5000);
        org.openqa.selenium.Alert myalert=driver.switchTo().alert();
        System.out.println(myalert.getText());
        myalert.accept();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
//        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
        
        org.openqa.selenium.Alert myPromt=driver.switchTo().alert();
        myPromt.sendKeys("Hello");
        myPromt.accept();
        
        

	}

}
