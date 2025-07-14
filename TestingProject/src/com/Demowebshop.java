package com;

import java.util.concurrent.ForkJoinPool.ManagedBlocker;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demowebshop {
public static void main(String[] args) throws InterruptedException {
	System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");
WebDriver driver = new ChromeDriver();
driver.get("https://demowebshop.tricentis.com/register");
driver.manage().window().maximize();

driver.findElement(By.xpath("//form[@action=\"/register\"]/div/div[2]/div[2]/div[2]/div[1]/div[2]/child::input")).click();

driver.findElement(By.xpath("//form[@action=\"/register\"]/div/div[2]/div[2]/div[2]/div[2]/child::input")).sendKeys("Gauri");

driver.findElement(By.xpath("//form[@action=\"/register\"]/div/div[2]/div[2]/div[2]/div[3]/child::input")).sendKeys("Bonde");

driver.findElement(By.xpath("//form[@action=\"/register\"]/div/div[2]/div[2]/div[2]/div[4]/child::input")).sendKeys("example@gmail.com");

driver.findElement(By.xpath("//form[@action=\"/register\"]/div/div[2]/div[3]/div[2]/div[1]/child::input")).sendKeys("gaurib");

driver.findElement(By.xpath("//form[@action=\"/register\"]/div/div[2]/div[3]/div[2]/div[2]/child::input")).sendKeys("gaurib");

driver.findElement(By.xpath("//form[@action=\"/register\"]/div/div[2]/div[4]/child::input")).click();

Thread.sleep(5000);
driver.close();
}
}
