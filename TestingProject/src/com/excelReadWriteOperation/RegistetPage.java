package com.excelReadWriteOperation;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegistetPage {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\138\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/register.php");
		driver.manage().window().maximize();

		// excel path
		String path = "D:\\My-Data\\JAVA\\ExcelReadWrite\\demo.xlsx";
		FileInputStream excelInputFile = new FileInputStream(path);

		XSSFWorkbook wd = new XSSFWorkbook(excelInputFile);

		XSSFSheet sh = wd.getSheet("RegisterPage");
		XSSFRow row = sh.getRow(1);

		XSSFCell cell = row.getCell(0);
		String fName = cell.getStringCellValue();

		XSSFCell cell1 = row.getCell(1);
		String lName = cell1.getStringCellValue();
		System.out.println(lName);

		XSSFCell cell2 = row.getCell(2);
		String phone = String.valueOf((long) cell2.getNumericCellValue());
		System.out.println("Phone: " + phone);

		XSSFCell cell3 = row.getCell(3);
		String email = cell3.getStringCellValue();
		
		XSSFCell cell4 = row.getCell(4);
		String address = cell4.getStringCellValue();
	
		XSSFCell cell5 = row.getCell(5);
		String city = cell5.getStringCellValue();
		
		XSSFCell cell6 = row.getCell(6);
		String state = cell6.getStringCellValue();
		
		XSSFCell cell7 = row.getCell(7);
		String zipCode = String.valueOf((long) cell7.getNumericCellValue());
		System.out.println("Zip Code: " +zipCode);
	
		XSSFCell cell8 = row.getCell(8);
		String country=cell8.getStringCellValue();
		
		XSSFCell cell9 = row.getCell(9);
		String uname = cell9.getStringCellValue();
		
		XSSFCell cell10 = row.getCell(10);
		String pass =cell10.getStringCellValue();
		
		XSSFCell cell11 = row.getCell(11);
		String confPass =cell11.getStringCellValue();

		driver.findElement(By.name("firstName")).sendKeys(fName);
		driver.findElement(By.name("lastName")).sendKeys(lName);
		driver.findElement(By.name("phone")).sendKeys(phone);
		driver.findElement(By.name("userName")).sendKeys(email);
		driver.findElement(By.name("address1")).sendKeys(address);
		driver.findElement(By.name("city")).sendKeys(city);
		driver.findElement(By.name("state")).sendKeys(state);
		driver.findElement(By.name("postalCode")).sendKeys(zipCode);
		driver.findElement(By.name("country")).sendKeys(country);
		driver.findElement(By.name("email")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("confirmPassword")).sendKeys(confPass);
		driver.findElement(By.name("submit")).click();

		Thread.sleep(2000);
		driver.close();
	}
}
