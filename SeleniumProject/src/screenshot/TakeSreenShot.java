package screenshot;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TakeSreenShot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        TakesScreenshot ts=(TakesScreenshot)driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File dis=new File(System.getProperty("user.dir")+"\\ScreenShot\\fullpage.png");
        src.renameTo(dis);
//        Delete all .png with while execution
        File dis1=new File(System.getProperty("user.dir")+"\\ScreenShot");
        if (dis1.exists() && dis1.isDirectory()) {
            File[] files = dis1.listFiles((dir, name) -> name.toLowerCase().endsWith(".png"));
            if (files != null) {
                for (File file : files) {
                    file.delete();
                }
            }
        }
     

	}

}
