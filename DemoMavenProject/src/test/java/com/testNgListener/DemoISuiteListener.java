package com.testNgListener;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class DemoISuiteListener implements ISuiteListener{
public void onStart(ISuite s)
{
	System.out.println("This is onStart Suite");
}
public void onFinish(ISuite s) {
	System.out.println("This is onFinish Suite");
}
}
