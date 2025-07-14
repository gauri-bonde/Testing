package CssSelector;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Attribute {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://softwaretestingplace.blogspot.com/p/manual-testing_11.html");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		WebElement search = driver.findElement(By.cssSelector("input[class='search-field'"));
		String s = search.getAttribute("placeholder");
		System.out.println("Attribute value of serach is: " + s);
		
		
		driver.close();
	}

}
