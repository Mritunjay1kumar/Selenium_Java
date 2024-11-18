package navigation;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationCommand {

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub
			WebDriver driver;
			
			WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        //driver.get("https://demo.nopcommerce.com/register?returnUrl=%2F");

	        driver.manage().window().maximize();
	        URL myurl=new URL("https://demo.nopcommerce.com/register?returnUrl=%2F");
	        driver.navigate().to(myurl);
	        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	        
	        driver.navigate().back();
	        System.out.println("Current Url is: "+driver.getCurrentUrl());
	        driver.navigate().forward();
	        System.out.println("Current Url is: "+driver.getCurrentUrl());
	        driver.navigate().refresh();
	}

}
