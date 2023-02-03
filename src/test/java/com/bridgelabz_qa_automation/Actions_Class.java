package com.bridgelabz_qa_automation;

import java.util.Scanner;

import javax.swing.Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Actions_Class {
	
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
	public void enter_Text_Into_Disable_Field() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.id("email"));
		actions.contextClick(element).perform();
		Thread.sleep(3000);
	} 
	
	@Test
	public void enter_DoubleClick_Into_Disable_Field() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.id("pass"));
		actions.doubleClick(element).perform();
		Thread.sleep(3000);
	} 
	
	@Test
	public void move_Element() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		WebElement element = driver.findElement(By.id("email"));
		Thread.sleep(3000);
		WebElement element1 = driver.findElement(By.id("pass"));
		actions.moveToElement(element1).click().perform();
		Thread.sleep(3000);
		actions.doubleClick(element).perform();
		Thread.sleep(3000);
	} 
	
	@Test
	public void drag_And_Drop() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement pick = driver.findElement(By.id("draggable"));
		WebElement drop  = driver.findElement(By.id("droppable"));
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.dragAndDrop(pick, drop).perform();
	}
	
	@Test
	public void click_Hold_And_Release() throws InterruptedException {
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		driver.switchTo().frame(0);
		WebElement pick = driver.findElement(By.id("draggable"));
		WebElement drop  = driver.findElement(By.id("droppable"));
		Thread.sleep(3000);
		Actions actions = new Actions(driver);
		actions.clickAndHold(pick).perform();
		actions.moveToElement(drop).release();
	}
	
	@Test
	public void keyBoard_Operations_Test() throws InterruptedException {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		Actions actions = new Actions(driver);
		driver.get("https://www.facebook.com/");
		WebElement element = driver.findElement(By.id("email"));
		actions.keyDown(Keys.SHIFT).perform();
		actions.sendKeys("Anurag");
		actions.keyDown(Keys.SHIFT).perform();
	}
	
	
}
