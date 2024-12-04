package headlessTesing;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeHeadless {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions optins=new ChromeOptions();
		optins.addArguments("headless");
		WebDriver driver = new ChromeDriver(optins);
		
		driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.quit();
        System.out.println("testcase");

	}

}
