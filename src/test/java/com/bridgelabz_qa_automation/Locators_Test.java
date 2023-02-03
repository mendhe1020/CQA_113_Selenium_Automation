package com.bridgelabz_qa_automation;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Locators_Test {
	
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
	    public void locators() {
	        driver.get("https://www.facebook.com/");
	        driver.manage().window().maximize();
	        driver.findElement(By.id("email")).sendKeys("anuragmendhe150@gmail.com");
	        driver.findElement(By.name("pass")).sendKeys("1063223231");
	        driver.findElement(By.name("login")).click();
	        driver.findElement(By.linkText("Forgetten")).click();
	    }
	    
	    @Test
	    public void locators_xpath() {
	        driver.get("https://www.facebook.com/");
	        driver.manage().window().maximize();
	        driver.findElement(By.xpath("//input[@placeholder='Email address or phone number']")).sendKeys("anuragmendhe150@gmail.com");
	        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("7038315685");
	        driver.findElement(By.xpath("//input[@id='keepLoggedInLabel']")).click();
	        driver.findElement(By.linkText("Forgetten")).click();
	        driver.findElement(By.partialLinkText("Forgetten")).click();
	        
	    }
	    
	    @Test
	    public void Facebook () throws InterruptedException {
	        driver.get("https://www.facebook.com/");
	        driver.manage().window().maximize();
	        String title = driver.getTitle();
	        System.out.println("facebook:" + title);
	        driver.findElement(By.id("email")).sendKeys("anuragmendhe150@gmail.com");
	        driver.findElement(By.name("pass")).sendKeys("106322323");
	        driver.findElement(By.name("login")).click();
	        Thread.sleep(10000);
	        driver.close();
	    }
	    
	    @Test
	    public void locators_Signup() {
	        driver.get("https://www.facebook.com/signup/");
	        driver.manage().window().maximize();
	        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Anurag");
	        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Mendhe");
	        driver.findElement(By.xpath("//input[@name=\'reg_email__\']")).sendKeys("anurag.mendhe12@gmail.com");
	        driver.findElement(By.xpath("//input[@name=\'reg_email_confirmation__\']")).sendKeys("anurag.mednhe14@gmail.com");
	        driver.findElement(By.xpath("//input[@name=\'reg_passwd__\']")).sendKeys("106322");
	        driver.findElement(By.xpath("//select[@name='birthday_day']")).sendKeys("6");
	        driver.findElement(By.xpath("//select[@name='birthday_month']")).sendKeys("Feb");
	        driver.findElement(By.xpath("//select[@name='birthday_year']")).sendKeys("1998");
	        driver.findElement(By.xpath("//input[contains(@id,'u_0_5')]")).click();
	        driver.findElement(By.xpath("//button[@name='websubmit']")).click();

	    }


}
