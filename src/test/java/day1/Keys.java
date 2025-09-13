package day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Keys {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//textarea[@id='inputText1']")).sendKeys("Viswakanth");

		Actions act = new Actions(driver);

		act.keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys("A").keyUp(org.openqa.selenium.Keys.CONTROL).perform();
		
		act.keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys("C").keyUp(org.openqa.selenium.Keys.CONTROL).perform();

		act.keyDown(org.openqa.selenium.Keys.TAB).perform();
		
		act.keyDown(org.openqa.selenium.Keys.CONTROL).sendKeys("V").keyUp(org.openqa.selenium.Keys.CONTROL).perform();


	}

}
