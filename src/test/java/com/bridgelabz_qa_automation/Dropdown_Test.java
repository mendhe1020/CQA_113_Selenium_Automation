package com.bridgelabz_qa_automation;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Dropdown_Test {
	WebDriver driver;

	@BeforeTest

	public void setup() {
		Scanner sc = new Scanner(System.in);

		int variable;
		System.out.println("Please enter the Num 1 Edge, 2 Chrome");

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
    public void select_By_Index() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("firstname")).sendKeys("Anurag");
        Thread.sleep(3000);
        driver.findElement(By.name("lastname")).sendKeys("Mendhe");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_email__")).sendKeys("anurag@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("anurag@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_passwd__")).sendKeys("123");
        Thread.sleep(3000);
        WebElement daydrop = driver.findElement(By.name("birthday_day"));
        Select day = new Select(daydrop);
        day.selectByIndex(9);
        Thread.sleep(3000);
        WebElement monthdrop = driver.findElement(By.name("birthday_month"));
        Select month = new Select(monthdrop);
        month.selectByIndex(1);
        Thread.sleep(3000);
        WebElement yeardrop = driver.findElement(By.name("birthday_year"));
        Select year = new Select(yeardrop);
        year.selectByIndex(25);
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[value='2']")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("websubmit")).click();
    }
	
	@Test
    public void select_By_Value() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("firstname")).sendKeys("Anurag");
        Thread.sleep(3000);
        driver.findElement(By.name("lastname")).sendKeys("Mendhe");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_email__")).sendKeys("anurag@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("anurag@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_passwd__")).sendKeys("A1234");
        Thread.sleep(3000);
        WebElement daydrop = driver.findElement(By.name("birthday_day"));
        Select day = new Select(daydrop);
        day.selectByValue("10");
        Thread.sleep(3000);
        WebElement monthdrop = driver.findElement(By.name("birthday_month"));
        Select month = new Select(monthdrop);
        month.selectByValue("2");
        Thread.sleep(3000);
        WebElement yeardrop = driver.findElement(By.name("birthday_year"));
        Select year = new Select(yeardrop);
        year.selectByValue("1998");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[value='2']")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("websubmit")).click();
    }
	
	@Test
    public void select_By_Visible_Text() throws InterruptedException {
        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("firstname")).sendKeys("Anurag");
        Thread.sleep(3000);
        driver.findElement(By.name("lastname")).sendKeys("Mendhe");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_email__")).sendKeys("anurag@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_email_confirmation__")).sendKeys("anurag@gmail.com");
        Thread.sleep(3000);
        driver.findElement(By.name("reg_passwd__")).sendKeys("A1234");
        Thread.sleep(3000);
        WebElement daydrop = driver.findElement(By.name("birthday_day"));
        Select day = new Select(daydrop);
        day.selectByVisibleText("10");
        Thread.sleep(3000);
        WebElement monthdrop = driver.findElement(By.name("birthday_month"));
        Select month = new Select(monthdrop);
        month.selectByVisibleText("Feb");
        Thread.sleep(3000);
        WebElement yeardrop = driver.findElement(By.name("birthday_year"));
        Select year = new Select(yeardrop);
        year.selectByVisibleText("1998");
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("input[value='2']")).click();
        Thread.sleep(3000);
        driver.findElement(By.name("websubmit")).click();
    }
}
