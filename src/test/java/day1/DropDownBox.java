package day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownBox {

	public static void main(String[] args) {

		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement dropCountryElement = driver.findElement(By.xpath("//select[@id='country']"));
		Select dropCountry = new Select(dropCountryElement);
		
		//dropCountry.selectByIndex(3);
		//dropCountry.selectByVisibleText("japan");
		
		
		List <WebElement> options = dropCountry.getOptions();
		System.out.println(options.size());
		/*
		for(int i=0;i<options.size();i++) {
			System.out.println("List in the Drop Box are "+ options.get(i).getText());
			
		}
		*/
		
		for(WebElement op: options) {
			System.out.println(op.getText());
		}
		driver.close();
	}

}
