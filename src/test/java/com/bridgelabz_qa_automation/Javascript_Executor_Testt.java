package com.bridgelabz_qa_automation;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Javascript_Executor_Testt {
	
	WebDriver driver;

	@BeforeTest

	public void setup() {
		Scanner sc = new Scanner(System.in);

		int variable;
		System.out.println("Please enter the Num 1 Edge, 2 Chrome, 3 Firfox");

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
    public void scroll_Down_WebPage() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,5000)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0,-3000)");
        Thread.sleep(2000);
    }
	
	@Test
    public void enter_Text_Into_Disabled_Field() throws InterruptedException {
        driver.get("file:///C:/Users/anura/Desktop/DisabledField.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.getElementById('t1').value='Anurag'");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').value='Mendhe'");
        Thread.sleep(2000);
        js.executeScript("document.getElementById('t2').type='button'");
        Thread.sleep(2000);
    }
	
	@Test
	public void frame_Handling_Test() throws InterruptedException {
		driver.get("file:///C:/Users/anura/Desktop/page2.html");
		driver.manage().window().maximize();
		driver.findElement(By.id("t2")).sendKeys("Anurag");
		Thread.sleep(2000);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.id("t1")).sendKeys("Mendhe");
		Thread.sleep(2000);
		driver.switchTo().defaultContent();
		Thread.sleep(2000);
	}
	
	
}
