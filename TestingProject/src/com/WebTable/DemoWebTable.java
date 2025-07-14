package com.WebTable;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoWebTable {
public static void main(String[] args) {
	System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.cricbuzz.com/live-cricket-scorecard/105842/eng-vs-wi-3rd-t20i-west-indies-tour-of-england-2025");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	WebElement in1 = driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]"));
	List<WebElement> inList =in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"]"));
	int in1Count = inList.size();
	System.out.println(in1Count);
	
	List<WebElement> runList =in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(3)"));
	int runCount = runList.size();
	System.out.println(runCount);
	
	int sum =0;
	for(int i=0; i < runCount - 3; i++)
	{
		String rValue = in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(3)")).get(i).getText();
	    int runVal = Integer.parseInt(rValue);
	    System.out.println(runVal);
	    sum = sum+runVal;
	}
	System.out.println("Total Player Sum Run is:  " + sum);
	
	//
	String  totalR=driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]/div[8]/div[2]")).getText();
    int extraRun = Integer.parseInt(totalR);
    System.out.println("Extra run value is: " +extraRun);

    int intotalrun = sum +extraRun;
    System.out.println(intotalrun);

   //Verified Total 
   String totalr = driver.findElement(By.xpath("//*[@id=\"innings_1\"]/div[1]/div[9]/div[2]")).getText();
   int totalRunVal = Integer.parseInt(totalr);
   System.out.println("total run value should be 248: " +totalRunVal);
   if(intotalrun == totalRunVal)
   {
	   System.out.println("Verified");
   }
   
   //ball Count
	List<WebElement> ballList =in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(4)"));
    int ballCount = ballList.size();
    System.out.println("The ball count is: " +ballCount);
    
   int sum1=0;
   for(int j=0; j< ballCount -1; j++)
   {
	   //System.out.println(j);
	   String h = in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(4)")).get(j).getText();
	   int ballVal = Integer.parseInt(h);
	    System.out.println(ballVal);
	    sum1 = sum1+ballVal;
	}
	System.out.println("Total Player Sum Ball Run is:  " + sum1);
	
	//4s total run
	List<WebElement> fourSList = in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(5)"));
    int foursCount = fourSList.size();
    System.out.println("The 4s count is " +foursCount);
    int sum2 =0;
    for(int k=0; k<foursCount-1;k++)
    {
    	String f =in1.findElements(By.cssSelector("div[class=\"cb-col cb-col-100 cb-scrd-itms\"] :nth-child(5)")).get(k).getText();
    	int fVal= Integer.parseInt(f);
    	System.out.println(fVal);
    	sum2=sum2+fVal;
    }
    System.out.println("4s Total Run is: " +sum2);

}
}
