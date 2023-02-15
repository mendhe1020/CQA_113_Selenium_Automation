package com.bridgelabz_qa_automation;

import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class webElement_Interface_Methods {

	WebDriver driver;

	@BeforeTest

	public void setup() {
		Scanner sc = new Scanner(System.in);

		int variable;
		System.out.println("Please enter the Num 1 Edge, 2 Chrome, 3 FireFox");

		variable = sc.nextInt();

		switch (variable) {
		case 1:
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\anura\\eclipse-workspace\\Selenium_Automation\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
			break;

		case 2:
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\anura\\eclipse-workspace\\Selenium_Automation\\Driver\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case 3:
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\anura\\eclipse-workspace\\Selenium_Automation\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
	}

	@Test
	public void page_Url_Validation() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String expectedUrl = "https://www.facebook.com/";
		String actaulUrl = driver.getCurrentUrl();
		System.out.println("the expected url is:" + expectedUrl);
		System.out.println("the acual url is:" + actaulUrl);
		driver.close();
		if (actaulUrl.equals(expectedUrl)) {
			System.out.println("url validation success");
		} else {
			System.out.println("url validation failed");
		}
	}

	@Test
	public void page_Title_Validation() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String expectedTitle = "Facebook – log in or sign up";
		String actaulTitle = driver.getTitle();
		System.out.println("the expected title is:" + expectedTitle);
		System.out.println("the acual title is:" + actaulTitle);
		driver.close();
		if (actaulTitle.equals(expectedTitle)) {
			System.out.println("title validation successs");
		} else {
			System.out.println("title validation failed");
		}
	}

	@Test
	public void page_Validation_Using_Web_Element() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.name("email"));
		driver.close();
		if (element.isDisplayed()) {
			System.out.println("element is displayed successfully");
		} else {
			System.out.println("element is not displayed");
		}
	}

	@Test
	public void create_new_account_is_display() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String text = driver.findElement(By.linkText("Create new account")).getText();
		System.out.println("link text is " + text);
		boolean d = driver.findElement(By.name("login")).isDisplayed();
		boolean e = driver.findElement(By.name("login")).isEnabled();
		boolean s = driver.findElement(By.name("login")).isSelected();
		System.out.println("isDisplayed " + d);
		System.out.println("isEnabled " + e);
		System.out.println("isSelected " + s);
		driver.close();
	}

	@Test
	public void email_sendKeys() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("anurag@gmail.com");
		Thread.sleep(3000);
		driver.findElement(By.id("email")).clear();
		driver.close();
	}

	@Test
	public void eamil_getTagname() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String tagname = driver.findElement(By.id("email")).getTagName();
		System.out.println(tagname);
		driver.close();
	}

	@Test
	public void getAttribute() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement element = driver.findElement(By.name("login"));
		String attri = element.getAttribute("id");
		System.out.println(attri);
		driver.close();
	}

	@Test
	public void eamil_getCssValue() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String csscolour = driver.findElement(By.id("email")).getCssValue("color");
		System.out.println(csscolour);
		driver.close();
	}

	@Test
	public void eamil_getlocation() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Point point = driver.findElement(By.id("email")).getLocation();
		System.out.println("X: " + point.x);
		System.out.println("y: " + point.y);
		driver.close();
	}

	@Test
	public void eamil_getSize() {

		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.name("email"));
		Dimension size = email.getSize();
		System.out.println("Height=" + size.getHeight());
		System.out.println("Width=" + size.getWidth());
		int w = size.height;
		int h = size.width;
		System.out.println("Height=" + w);
		System.out.println("Width=" + h);
		driver.close();
	}
	
	@Test
    public void webelement_Clear_And_Sendkey_Method() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.id("email")).sendKeys("anurag@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("email")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys("anurag@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.id("email")).sendKeys(Keys.CONTROL+"a"+ Keys.DELETE);
    }
    
    @Test
    public void webelement_Click_Method() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.name("login")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
    }

	@Test
	public void email_Error_Message() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.name("login")).click();
		String expectedError = "Find your account and log in.";
		System.out.println("expected error is:" + expectedError);
		WebElement element = driver.findElement(By.linkText("Find your account and log in."));
		String actualError = element.getText();
		driver.close();
		if (actualError.equals(expectedError)) {
			System.out.println("error message is validated");
		} else {
			System.out.println("error message is not validated");

		}
	}

	@Test
	public void password_Error_Message() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("anurag@gmail.com");
		driver.findElement(By.name("login")).click();
		String expectedError = "Forgotten password?";
		System.out.println("expected error is:" + expectedError);
		WebElement element = driver.findElement(By.linkText("Forgotten password?"));
		String actualError = element.getText();
		driver.close();
		if (actualError.equals(expectedError)) {
			System.out.println("error message is validated");
		} else {
			System.out.println("error message is not validated");

		}
	}

	@Test
	public void email_entered_isnt_connected_to_an_account() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("email")).sendKeys("an");
		driver.findElement(By.name("pass")).sendKeys("1063");
		driver.findElement(By.name("login")).click();
		String expectedError = "Find your account and log in.";
		System.out.println("expected error is:" + expectedError);
		WebElement element = driver.findElement(By.linkText("Find your account and log in."));
		String actualError = element.getText();
		driver.close();
		if (actualError.equals(expectedError)) {
			System.out.println("error message is validated");
		} else {
			System.out.println("error message is not validated");

		}
	}
}
