package com.capturingScreenShot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CapturingScreenShot {
public static void main(String[] args) throws IOException, InterruptedException {
	System.setProperty("webdriver.chrome.driver","D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.facebook.com/");
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	
	File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src, new File("D:\\My-Data\\JAVA\\ScreenShots\\ss.jpg"));
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("facebook@gmail.com");
	File src1 =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(src1, new File("D:\\My-Data\\JAVA\\ScreenShots\\ss1.jpg"));
	
	Thread.sleep(2000);
	driver.close();
}
}
