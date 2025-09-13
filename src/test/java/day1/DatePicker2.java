package day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePicker2 {

	/*
	 * static Month convertMonth(String month) {
	 * 
	 * HashMap<String, Month> monthMap = new HashMap<String, Month>();
	 * monthMap.put("Jan", Month.JANUARY); monthMap.put("Feb", Month.FEBRUARY);
	 * monthMap.put("Mar", Month.MARCH); monthMap.put("Apr", Month.APRIL);
	 * monthMap.put("May", Month.MAY); monthMap.put("Jun", Month.JUNE);
	 * monthMap.put("Jul", Month.JULY); monthMap.put("Aug", Month.AUGUST);
	 * monthMap.put("Sep", Month.SEPTEMBER); monthMap.put("Oct", Month.OCTOBER);
	 * monthMap.put("Nov", Month.NOVEMBER); monthMap.put("Dec", Month.DECEMBER);
	 * 
	 * Month vmonth = monthMap.get(month); if (vmonth == null) {
	 * System.out.println("Invalid Month.....");
	 * 
	 * }
	 * 
	 * return vmonth;
	 * 
	 * }
	 */

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// input Date
		String requiredYear = "2016";
		String requiredMonth = "Jan";
		String requiredDay = "22";

		driver.findElement(By.xpath("//input[@id='txtDate']")).click();

		// select year

		WebElement yearDropDown = driver.findElement(By.xpath("//select[@aria-label='Select year']"));
		Select selectYear = new Select(yearDropDown);
		selectYear.selectByVisibleText(requiredYear);

		WebElement monthDropDown = driver.findElement(By.xpath("//select[@aria-label='Select month']"));
		Select selectMonth = new Select(monthDropDown);
		selectMonth.selectByVisibleText(requiredMonth);

		List<WebElement> allDate = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//tr//td//a"));

		for (WebElement dt : allDate) {
			if (dt.getText().equals(requiredDay)) {
				dt.click();
				break;
			}
		}

		// select month
		/*
		 * while (true) { String displayMonth =
		 * driver.findElement(By.xpath("//select[@aria-label='Select month']")).getText(
		 * );
		 * 
		 * // convert string month to Month object
		 * 
		 * Month expectMonth = convertMonth(requiredMonth); Month currentMonth =
		 * convertMonth(displayMonth);
		 * 
		 * int result = expectMonth.compareTo(currentMonth);
		 * 
		 * if (result < 0) { driver.findElement(By.xpath("//a[@title='Prev']")).click();
		 * } else if (result > 0) {
		 * driver.findElement(By.xpath("//a[@title='Next']")).click(); } else { break; }
		 * }
		 */

	}

}
