package day1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {


	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		List<WebElement> links = driver.findElements(By.tagName("a"));
		System.out.println("No of links in the URL  =====>" + links.size());
		int noOFBrokenLinks = 0, noOfNonBrokenLinks = 0;

		for (WebElement linkELement : links) {
			String hrefAttValue = linkELement.getAttribute("href");
			if (hrefAttValue == null || hrefAttValue.isEmpty()) {
				System.out.println("hrefAttValue is empty so it is not possible to check .......");
 
				continue;
			}
			try {
				URL linkURL = new URL(hrefAttValue);
				HttpURLConnection conn = (HttpURLConnection) linkURL.openConnection();
				conn.connect();
				if (conn.getResponseCode() >= 400) {
					System.out.println(hrefAttValue + " ======> is a Broken link");
					noOFBrokenLinks++;
				} else {
					System.out.println(hrefAttValue + " =======> in not a Broken link");
					noOfNonBrokenLinks++;
				}

			} catch (Exception e) {

			}
		}
		System.out.println("Total no of Broken Links ======> " + noOFBrokenLinks);
		System.out.println("Total no of Non Broken Links ======> " + noOfNonBrokenLinks);

	}

}
