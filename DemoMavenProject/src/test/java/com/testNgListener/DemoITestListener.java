package com.testNgListener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class DemoITestListener implements ITestListener {
	public void onStart(ITestContext c) {
		System.out.println("This is onStart method");
	}

	public void onFinisht(ITestContext c) {
		System.out.println("This is onFinish method");
	}
	public void onTestStart(ITestResult c) {
		System.out.println("This is onTestStart method");
	}
	public void onTestSuccess(ITestResult c) {
		System.out.println("This is onTestSuccess method");
	}
	public void onTestFailure(ITestResult c) {
		System.out.println("This is onTestFailure method");
	}
	public void onTestSkipped(ITestResult c) {
		System.out.println("This is onTestSkipped method");
	}
	public void onTestFailedButWithinSuccessPercentage(ITestResult c) {
		System.out.println("This is onTestFailedButWithinSuccessPercentage method");
	}
}
