package table;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PriceSumTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        int row=driver.findElements(By.xpath("//*[@name=\"BookTable\"]//tr")).size();
        int col=driver.findElements(By.xpath("//*[@name=\"BookTable\"]//tr/th")).size();
        System.out.println("ROW is: "+ row+ " col is: "+col);
        int price=0;
        List<String> prices=new ArrayList<>();
        for(int r=2;r<=row;r++) {
        	String s=driver.findElement(By.xpath("//*[@name=\"BookTable\"]//tr["+r+"]//td[4]")).getText();
        	prices.add(s);
        	price=price+Integer.parseInt(s);
        }
        System.out.println("total price is "+price);
        System.out.println(prices);

	}

}
