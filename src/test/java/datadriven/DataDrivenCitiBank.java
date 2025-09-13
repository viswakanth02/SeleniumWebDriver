package datadriven;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenCitiBank {

	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.cit.com/cit-bank/resources/calculators/certificate-of-deposit-calculator");
		driver.manage().window().maximize();

		String filPath = System.getProperty("user.dir") + "\\testdata\\cti-data.xlsx";
		int rows = ExcelUtils.getRowCount(filPath, "Sheet1");
		for (int r = 1; r <= rows; r++) {
			// reading data from Excel Sheet
			String depoAmount = ExcelUtils.getCellData(filPath, "Sheet1", r, 0);
			String lmonth = ExcelUtils.getCellData(filPath, "Sheet1", r, 1);
			String intRate = ExcelUtils.getCellData(filPath, "Sheet1", r, 2);
			String compounding = ExcelUtils.getCellData(filPath, "Sheet1", r, 3);
			String exp_Value = ExcelUtils.getCellData(filPath, "Sheet1", r, 4);

			WebElement amount = driver.findElement(By.xpath("//input[@id='mat-input-0']"));
			WebElement months = driver.findElement(By.xpath("//input[@id='mat-input-1']"));
			WebElement rateOfInt = driver.findElement(By.xpath("(//input[@id='mat-input-2'])[1]"));
			amount.clear();
			amount.sendKeys(depoAmount);
			months.clear();
			months.sendKeys(lmonth);
			rateOfInt.clear();
			rateOfInt.sendKeys(intRate);
			Select compoundInt = new Select(driver.findElement(By.className("mat-mdc-select-value")));
			compoundInt.selectByVisibleText(compounding);
			driver.findElement(By.xpath("//button[@id='CIT-chart-submit']")).click();
			String act_Value = driver.findElement(By.xpath("(//span[@id='displayTotalValue'])[1]")).getText();
			
			if(Double.parseDouble(act_Value)==Double.parseDouble(exp_Value)) {
				System.out.println("Test in Passed");
				ExcelUtils.setCellData(filPath, "Sheet1", r, 6,"Passed");
				ExcelUtils.fillGreenColour(filPath, "Sheet1", r, 6);
			}else {
				System.out.println("Test in Failed");
				ExcelUtils.setCellData(filPath, "Sheet1", r, 6,"Failed");
				ExcelUtils.fillRedColour(filPath, "Sheet1", r, 6);
			}
			
			Thread.sleep(5000);
		}
		driver.quit();
	}

}
