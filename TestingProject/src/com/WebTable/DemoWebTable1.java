package com.WebTable;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebTable1 {
	public static void main(String[] args) 
	{
	System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.cricbuzz.com/live-cricket-scorecard/105842/eng-vs-wi-3rd-t20i-west-indies-tour-of-england-2025");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	WebElement in2 = driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[4]"));
	List<WebElement> in2List = in2.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms ']"));
	int in2Count = in2List.size();
	System.out.println(in2Count);
	
	List<WebElement> overList =in2.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms '] :nth-child(2)"));
    int overCount = overList.size();
    System.out.println("Over Count is: " +overCount);
    
    int sum =0;
    for(int i=0; i<overCount; i++)
    {
    String oValue = in2.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms '] :nth-child(2)")).get(i).getText();
    int overValue = Integer.parseInt(oValue);
    System.out.println(overValue);
    sum =sum+overValue;
    }
    System.out.println("The Toral of Over is : " +sum);
    
    //Run Total
    List<WebElement> runList =in2.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms '] :nth-child(4)"));
	int rCount = runList.size();
	System.out.println("The run count is: " +rCount);
	
	int sum1=0;
	for(int j=0; j<rCount; j++)
	{
		String rValue = in2.findElements(By.cssSelector("div[class='cb-col cb-col-100 cb-scrd-itms '] :nth-child(4)")).get(j).getText();
		int runVal =Integer.parseInt(rValue);
		System.out.println(runVal);
		sum1 =sum1+runVal;
	}
	System.out.println("total second inning Run is: " +sum1);
	}
}
