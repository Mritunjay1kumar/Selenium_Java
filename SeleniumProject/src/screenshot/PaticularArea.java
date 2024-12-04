package screenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaticularArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.automationtesting.in/Register.html");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakesScreenshot ts=(TakesScreenshot)driver;
        WebElement form=driver.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]"));
        File src=form.getScreenshotAs(OutputType.FILE);
        File dis=new File(System.getProperty("user.dir")+"\\ScreenShot\\fullpage.png");
        src.renameTo(dis);
	}

}
