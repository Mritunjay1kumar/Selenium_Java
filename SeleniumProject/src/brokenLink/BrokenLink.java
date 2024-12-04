package brokenLink;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLink {
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.deadlinkcity.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        List<WebElement> links = driver.findElements(By.tagName("a"));
        int cnt=0;
        for(WebElement link:links) {
        	String url=link.getAttribute("href");
        	if(url==null || url.isEmpty()) {
        		System.out.println("href attribute is null or empty so not possible to check");
        		continue;
        	}
        	try {
        		URL linkURL=new URL(url);
            	HttpURLConnection connectionLinkUrl=(HttpURLConnection) linkURL.openConnection();
            	connectionLinkUrl.connect();
            	int res=connectionLinkUrl.getResponseCode();
            	if(res>=400) {
            		cnt++;
            		System.out.println("Broken link is: "+linkURL);
            	}
            	else {
            		System.out.println("Link is not Broken"+linkURL);
            	}
        	}
        	catch (Exception e) {
                e.printStackTrace();
            }
        	
        }
        System.out.println("Total link broken"+cnt);

	}



}
