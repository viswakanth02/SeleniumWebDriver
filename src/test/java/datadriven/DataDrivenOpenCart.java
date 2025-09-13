package datadriven;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDrivenOpenCart {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();

		String filPath = System.getProperty("user.dir") + "\\testdata\\OpenCart_data.xlsx";
		int rows = ExcelUtils.getRowCount(filPath, "Sheet1");
		for (int r = 1; r <= rows; r++) {
			// reading data from Excel Sheet
			String username = ExcelUtils.getCellData(filPath, "Sheet1", r, 0);
			String pwd = ExcelUtils.getCellData(filPath, "Sheet1", r, 1);
			String exp = ExcelUtils.getCellData(filPath, "Sheet1", r, 2);

			WebElement myAccount = driver.findElement(By.xpath("//span[normalize-space()='My Account']"));
			WebElement login = driver.findElement(By.xpath("//a[normalize-space()='Login']"));
			WebElement email = driver.findElement(By.xpath("//input[@id='input-email']"));
			WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
			WebElement btn = driver.findElement(By.xpath("//input[@value='Login']"));
			String targetMst = driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).getText();

			WebElement logout = driver
					.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']"));
			myAccount.click();
			login.click();
			email.sendKeys(username);
			password.sendKeys(pwd);
			btn.click();

			/*
			 * if (exp.equalsIgnoreCase("Valid")) { if (targetMst == true) { logout.click();
			 * Assert.assertTrue(true); } else { Assert.assertTrue(false); } } if
			 * (exp.equalsIgnoreCase("Invalid")) { if (targetMst == true) { logout.click();
			 * Assert.assertTrue(false); } else { Assert.assertTrue(true); } }
			 */

			Thread.sleep(5000);
		}
		driver.quit();
	}

}
