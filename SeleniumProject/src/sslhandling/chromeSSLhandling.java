package sslhandling;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chromeSSLhandling {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions optins=new ChromeOptions();
		optins.setAcceptInsecureCerts(true);
		WebDriver driver = new ChromeDriver(optins);
		driver.get("https://expired.badssl.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());

	}

}
