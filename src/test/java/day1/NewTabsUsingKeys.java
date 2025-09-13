package day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class NewTabsUsingKeys {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();

		WebElement reg_link = driver.findElement(By.xpath("//a[normalize-space()='Register']"));
		Actions act = new Actions(driver);

		act.keyDown(Keys.CONTROL).click(reg_link).keyUp(Keys.CONTROL).perform();

		List<String> win = new ArrayList<String>(driver.getWindowHandles());

		driver.switchTo().window(win.get(1));

		driver.findElement(By.xpath("//input[@id='FirstName']")).sendKeys("Viswakanth");

		driver.switchTo().window(win.get(0));
		driver.findElement(By.xpath("//input[@id='small-searchterms']")).sendKeys("Shoes");
		
		driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

	}

}
