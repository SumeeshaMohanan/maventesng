package testScripts;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerDemo implements ITestListener {

	public void onTestStart(ITestResult result) {
		System.out.println("Test start "+ result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Success "+ result.getName());
		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test Failure "+ result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test skipped "+ result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("Test Failure "+ result.getName());
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	

	
}
