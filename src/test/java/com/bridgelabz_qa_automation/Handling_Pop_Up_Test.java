package com.bridgelabz_qa_automation;

import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handling_Pop_Up_Test {

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
	public void simple_Alert_Popup_Test() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
	}

	@Test
	public void alert_Popup_Test() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.id("confirmButton")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
	}

	@Test
	public void prompt_Popup__Test() throws InterruptedException {
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		driver.findElement(By.id("promtButton")).click();
		Thread.sleep(3000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
	}

	@Test
	public void hidden_Division_Popup() throws InterruptedException {
		driver.get("https://www.cleartrip.com/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//button[@class='flex flex-middle  t-all fs-2 focus:bc-secondary-500 bg-transparent bc-neutral-100 c-pointer pr-2 pl-3 pt-2 pb-2 ba br-4 h-8 c-neutral-900']"))
				.click();
		driver.findElement(By.xpath("//div[@aria-label='Thu Feb 02 2023']")).click();
	}

	@Test
	public void file_Upload_Popup() throws IOException {
		driver.get("https://www.freepdfconvert.com/pdf-to-word");
		driver.manage().window().maximize();
		driver.findElement(By.linkText("Choose PDF file")).click();
		Runtime.getRuntime().exec("D:\\cqa.exe");
	}

	@Test
	public void files_Upload_Popup() throws IOException {
		driver.get("https://www.ilovepdf.com/merge_pdf");
		driver.manage().window().maximize();
		driver.findElement(By.id("pickfiles")).click();
		Runtime.getRuntime().exec("D:\\cqa.exe");
	}

	@Test
	public void get_The_Window_ID_Test() {
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		String windowid = driver.getWindowHandle();
		System.out.println("The current window id is: " + windowid);
	}

	@Test
	public void child_Browser_Popup() throws InterruptedException {
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		driver.manage().window().maximize();
		String parentId = driver.getWindowHandle();
		System.out.println("The current window id is: " + parentId);
		driver.findElement(By.xpath("//a[@aria-label='Menu Flight. Website will be opened in new tab']")).click();
		Set<String> allWindowID = driver.getWindowHandles();
		System.out.println("The current window id are: " + allWindowID);
		int count = allWindowID.size();
		System.out.println("The current window open by selenium are: " + count);
		for (String windowHandale : allWindowID) {
			driver.switchTo().window(windowHandale);
			String title = driver.getTitle();
			System.out.println("The tital is: " + title);
			if (windowHandale.equals(parentId)) {
				driver.close();
			}
		}
		driver.quit();
	}

}
