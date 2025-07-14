package testNGProjectFirst;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

public class DemoWebShop {
	WebDriver driver;
	WebDriverWait wait;

	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\My-Data\\JAVA\\Selenium\\138\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@BeforeTest
	public void beforeTest() {
		driver.get("https://demowebshop.tricentis.com/");
		String currUrl = driver.getCurrentUrl();
		Assert.assertEquals(currUrl, "https://demowebshop.tricentis.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

	}

	@BeforeClass
	public void beforeClass() {
		driver.manage().window().maximize();
	}

	@BeforeMethod
	public void beforeMethod() {
		Set<Cookie> co = driver.manage().getCookies();
		System.out.println(co.size());
		wait = new WebDriverWait(driver, 10);
	}

//Click on Register & pass parameters through .xml
	@Test(priority = 1)
	@Parameters({ "fName", "lName", "email", "pass", "cPass" })
	public void register(String firstName, String lastName, String email, String password, String confPass) {

		WebElement reg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Register']")));
		reg.click();

		System.out.println("Register click Successfully");

		driver.findElement(By.xpath("//*[@id='gender-female']")).click();
		driver.findElement(By.xpath("//*[@id=\"FirstName\"]")).sendKeys(firstName);
		driver.findElement(By.xpath("//*[@id='LastName']")).sendKeys(lastName);
		driver.findElement(By.xpath("//*[@id='Email']")).sendKeys(email);

		driver.findElement(By.xpath("//*[@id='Password']")).sendKeys(password);
		driver.findElement(By.xpath("//*[@id='ConfirmPassword']")).sendKeys(confPass);

		driver.findElement(By.xpath("//*[@id='register-button']")).click();
	}

	@Test(priority = 2, dataProvider = "getData")

	public void userLogin(String email, String pass) throws InterruptedException {
		// Click logout if user is already logged in
		if (driver.findElements(By.xpath("//a[text()='Log out']")).size() > 0) {
			driver.findElement(By.xpath("//a[text()='Log out']")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[text()='Log in']")).click();

		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pass);

		driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]")).click();
	}

//Add to car book & Checkout 
	@Test(priority = 3)
	public void addToCartProduct() throws InterruptedException {
		SoftAssert sa = new SoftAssert(); // use assert
		WebElement book = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[4]/div[1]/div[2]/ul[1]/li[1]")));
		book.click();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("(scrollBy(0, 200))");

		// Add to cart Book
		WebElement addToCartBook = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[@data-productid='13']//input[@value='Add to cart']")));
		addToCartBook.click();
	

		// Shopping Cart
		/*
		 * Thread.sleep(2000); WebElement shoppingCart = wait
		 * .until(ExpectedConditions.elementToBeClickable(By.
		 * xpath("//span[text()='Shopping cart']")));
		 * 
		 * shoppingCart.click();
		 * 
		 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
		 * xpath("//h1[text()='Shopping cart']")));
		 * 
		 * System.out.println("Navigated to Shopping Cart Page");
		 */
		Thread.sleep(3000);
		WebElement shoppingCart = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"topcartlink\"]/a/span[1]")));
		Actions action = new Actions(driver);
		action.moveToElement(shoppingCart).perform();
		System.out.println("Mouse hovered on Shopping cart");

		WebElement cartBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@class='button-1 cart-button']")));
		cartBtn.click();
		System.out.println("Clicked on cart button, current URL: " + driver.getCurrentUrl());

		// select checkBox
		WebElement checkBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='termsofservice']")));
		if (!checkBox.isSelected()) {
			driver.findElement(By.xpath("//input[@id='termsofservice']")).click();
		}
		Assert.assertTrue(checkBox.isSelected(), "Checkbox was not selected properly.");

		// CheckOut
		WebElement checkOut = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='checkout-buttons']")));
		checkOut.click();
		System.out.println("Product has been checked out");

		sa.assertAll();
	}

//Fill All details of Billing address
	@Test(priority = 4, dependsOnMethods = "addToCartProduct")
	@Parameters({ "city", "add1", "zip", "phone" })

	public void billingAdd(String city, String address, String zipCode, String phoneNum) throws InterruptedException {
		WebElement country = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//select[@name='BillingNewAddress.CountryId']")));
		country.click();
		Select select = new Select(country);
		select.selectByVisibleText("India");

		WebElement billcity = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@name='BillingNewAddress.City']")));
		billcity.sendKeys(city);

		WebElement add1 = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='BillingNewAddress_Address1']")));
		add1.sendKeys(address);

		WebElement zipC = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='BillingNewAddress_ZipPostalCode']")));
		zipC.sendKeys(zipCode);

		WebElement phone = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='BillingNewAddress_PhoneNumber']")));
		phone.sendKeys(phoneNum);

		Thread.sleep(1000);
		WebElement conBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"billing-buttons-container\"]/input")));
		conBtn.click();
	}

	@Test(priority = 5, dependsOnMethods = "billingAdd")
	public void continuePaymentProcess() {
		WebElement shipAdd = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='shipping-buttons-container']/input")));
		shipAdd.click();

		WebElement shipMethod = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@class='button-1 shipping-method-next-step-button']")));
		shipMethod.click();

		WebElement paymentMethod = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@class='button-1 payment-method-next-step-button']")));
		paymentMethod.click();

		WebElement paymentInformation = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"payment-info-buttons-container\"]/input")));
		paymentInformation.click();

		WebElement confirmOrder = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/input")));
		confirmOrder.click();
		System.out.println("Your order has been successfully processed!");

	}

	@Test(priority = 6, dependsOnMethods = "continuePaymentProcess")
	public void OrderDetail() {
		WebElement orderDetails = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Click here for order details.']")));
		orderDetails.click();
		System.out.println("Your order Details");
	}

	@AfterMethod
	public void afterMethod() {
	}

	@AfterClass
	public void afterClass() {
		driver.manage().deleteAllCookies();

	}

	@AfterTest
	public void afterTest() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

	@DataProvider
	public Object[][] getData() {
		return new Object[][] { new Object[] { "gauri3@gmail.com", "gauri#123" } };
	}
}
