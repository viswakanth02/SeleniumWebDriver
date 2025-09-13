package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test is started here..........");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test is successed............");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed...........");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped..........");
	}

	public void onStart(ITestContext context) {
		System.out.println("Started here..........");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Ended here...........");
	}

}
