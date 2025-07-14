package CssSelector;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\137\\chromedriver-win64\\chromedriver.exe");
		WebDriver driver;
		driver = new ChromeDriver();
		driver.get("https://jpetstore.aspectran.com/account/newAccountForm");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		boolean isDisplayed = false;
		boolean isInputDisplayed = false;
		boolean isPwDisplayed = false;
		try {
			WebElement btn = driver.findElement(By.cssSelector("button.button")); // class cssSelector
			isDisplayed = btn.isDisplayed();

			// tagname,attribute,name
			WebElement fn = driver.findElement(By.cssSelector("input[name='username']"));
			isInputDisplayed = fn.isDisplayed();
			fn.sendKeys("gauri");
			String inputValue = fn.getAttribute("value");
			System.out.println("Attribute valise is:" +inputValue);
			//Match with prefix
			WebElement pw = driver.findElement(By.cssSelector("input[name^='pa']"));
			isPwDisplayed = pw.isDisplayed();
			
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			System.out.println("One of the elements was not found." +e.getMessage());
		}
		System.out.println("Is button displayed? " + isDisplayed);
		System.out.println("Is input type displayed? " + isInputDisplayed);
		System.out.println("Is input password displayed? " + isPwDisplayed);
		
		Thread.sleep(2000);
		driver.close();
	}
}
