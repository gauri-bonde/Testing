package com.excelReadWriteOperation;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelReadtAndWrite {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\138\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours/login.php");
		// get excel path
		String path = "D:\\My-Data\\JAVA\\ExcelReadWrite\\demo.xlsx";
		FileInputStream fis = new FileInputStream(path);

		//
		XSSFWorkbook wd = new XSSFWorkbook(fis);

		XSSFSheet sh = wd.getSheet("LoginPage"); //sheet name
		XSSFRow row = sh.getRow(1);
		XSSFCell cell = row.getCell(0);

		String uname = cell.getStringCellValue();
		System.out.println(uname);
		XSSFCell cell1 = row.getCell(1);

		String pass = cell1.getStringCellValue();
		System.out.println(pass);

		// send data to input fileds
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("submit")).click();

		// Write data on excel file
		XSSFCell cc = sh.getRow(0).createCell(2);
		cc.setCellValue("Status");

		FileOutputStream fos = new FileOutputStream(path);
		wd.write(fos);

		Thread.sleep(2000);
		driver.close();
	}
}
