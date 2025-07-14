package com.webelementMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jpetstore {
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\My-Data\\JAVA\\Selenium\\131\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://jpetstore.aspectran.com/account/newAccountForm");
		
		driver.manage().window().maximize();
		
		/*WebElement Methods*/
		//1.senKeys()
          WebElement userId = driver.findElement(By.xpath("//input[@name='username']"));
          userId.sendKeys("userid");
		
          //2. Click();
          Thread.sleep(2000);
          WebElement newPass = driver.findElement(By.name("password"));
          newPass.click();
          newPass.sendKeys("password");
          
          //3.Clear()
          Thread.sleep(3000);
          WebElement clearVal = driver.findElement(By.name("repeatedPassword"));
          clearVal.sendKeys("password");
          clearVal.clear();
          
          //4.getText();
          WebElement firstName = driver.findElement(By.xpath("//section/div[2]/div[2]/div/form/table/tbody/tr/td"));
          String txtValue = firstName.getText();
          System.out.println(txtValue);
          
          //5. getAttribute("value")
          WebElement fn =driver.findElement(By.xpath("//input[@name='firstName']"));
          fn.sendKeys("FirstName");
          Thread.sleep(2000);
          String fnValue =fn.getAttribute("value");
          System.out.println(fnValue);
          
          //6.isDisplayed();
          WebElement sn =driver.findElement(By.xpath("//input[@name='lastName']"));
	      Boolean idu = sn.isDisplayed();
	      System.out.println("isDisplayed : " + idu);
	      
	      //7.isSelected();
	      WebElement radioButton =driver.findElement(By.xpath("//input[@name='listOption']"));
	      Boolean rc = radioButton.isSelected();
	      System.out.println("isSelected: " +rc );
	      
	      //8.isEnabled()
	      WebElement subButton =driver.findElement(By.xpath("//div[@class='button-bar']"));
	      Boolean isEnab = subButton.isEnabled();
	      System.out.println("isEnabled: " +isEnab );
	      

 	}
}
