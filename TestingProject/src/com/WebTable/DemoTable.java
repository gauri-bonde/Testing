package com.WebTable;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoTable {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("D:\\My-Data\\JAVA\\Table.html");
		driver.manage().window().maximize();
		
		List<WebElement> alltr = driver.findElements(By.tagName("tr"));
		int trCount =alltr.size();
		//System.out.println(alltr);

		//To print all table data
		for (WebElement rows : alltr) {
			List<WebElement> atd = rows.findElements(By.tagName("td"));
			int atdCount = atd.size();
		//	System.out.println(atdCount);
			for(WebElement cols : atd)
			{
				System.out.println(cols.getText());
			}
		}
		
		//To print perticular row data
		System.out.println("------------Print tr6-------------");
		List<WebElement> tr6 = driver.findElements(By.xpath("/html/body/table/tbody/tr[8]"));
		for (WebElement pcol : tr6) {
			System.out.println(pcol.getText());
		}
		
		Thread.sleep(2000);
		driver.close();
	}
}
