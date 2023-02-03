package com.bridgelabz_qa_automation;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Handling_Mouse_Keyboard_Oprection {

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
	public void mouse_and_Keyboard_Operations() throws AWTException {

		driver.get("https://www.bridgelabz.com/");
		driver.manage().window().maximize();
		Robot robot = new Robot();
		robot.mouseMove(300, 500);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_S);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_S);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_F);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_F);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_W);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_W);
	}

}
