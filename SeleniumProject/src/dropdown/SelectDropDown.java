package dropdown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SelectDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement drpCountry=driver.findElement(By.xpath("//select[@id=\"country\"]"));
        Select drpCountryElement=new Select(drpCountry);
//        drpCountryElement.selectByVisibleText("Germany");
        //drpCountryElement.selectByValue("france");
        drpCountryElement.selectByIndex(1);
        List<WebElement> elementCount = drpCountryElement.getOptions();
        System.out.println(elementCount.size());
//        for(int i=0;i<elementCount.size();i++) {
//        	System.out.println(elementCount.get(i).getText());
//        }
        for(WebElement op:elementCount) {
        	System.out.println(op.getText());
        }
        
	}

}
