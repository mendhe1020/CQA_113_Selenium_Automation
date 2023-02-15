package com.bridgelabz_qa_automation;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
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
		Thread.sleep(3000);
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
	public void file_Upload_Using_Sendkey() {
		driver.get("http://nervgh.github.io/pages/angular-file-upload/examples/simple/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='file'][@multiple='']")).sendKeys("C:\\Users\\anura\\Downloads");
		driver.findElement(By.xpath("//button[@type='button'][@ng-click='uploader.uploadAll()']")).click();
	}

	@Test
	public void FileDownload_WithChrome() throws InterruptedException {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", "C:\\Users\\admin\\Downloads\\Default Folder");
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(ChromeOptions.CAPABILITY, options);
//      driver = new ChromeDriver(cap);
		driver.get("http://www.seleniumhq.org/download/");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String xp = "//div[3]//div[1]//div[2]//p[2]//a[1]";
		driver.findElement(By.xpath(xp)).click();
	}

	@Test
	public void is_Multiple_Method() throws InterruptedException {
		driver.get("file:///C:/Users/anura/OneDrive/Desktop/asd.html");
		driver.manage().window().maximize();
		WebElement list = driver.findElement(By.id("mtr"));
		Select s = new Select(list);
		List<WebElement> options = s.getOptions();
		int size = options.size();
		System.out.println("Number of elements present inside the listbox is:" + size);
		for (WebElement webElement : options) {
			String text = webElement.getText();
			System.out.println(text);
		}
		s.selectByIndex(0);
		Thread.sleep(3000);
		s.selectByValue("v");
		Thread.sleep(3000);
		s.selectByVisibleText("Poori");
		Thread.sleep(3000);
		List<WebElement> allSelectOptions = s.getAllSelectedOptions();
		int size2 = allSelectOptions.size();
		System.out.println("Number of item that is selected in the list box is:" + size2);
		for (WebElement webElement : allSelectOptions) {
			System.out.println(webElement.getText());
		}
		boolean multiple = s.isMultiple();
		System.out.println(multiple + " yes,it is multi select");
		if (multiple) {
			WebElement firstSelectedOption = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption.getText() + " is the first selected item in the list box");
			s.deselectByIndex(0);
			Thread.sleep(3000);
			WebElement firstSelectedOption1 = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption1.getText() + " is the first selected item");
			s.deselectByValue("v");
			Thread.sleep(3000);
			WebElement firstSelectedOption2 = s.getFirstSelectedOption();
			System.out.println(firstSelectedOption2.getText() + " is the first selected item");
			s.deselectByVisibleText("Poori");
			Thread.sleep(3000);
			driver.close();
			Thread.sleep(3000);
		}
	}

	@Test
	public void child_Browser_Popup() throws InterruptedException {
		driver.get("https://www.irctc.co.in/nget/profile/user-registration");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		String parentId = driver.getWindowHandle();
		Thread.sleep(3000);
		System.out.println("The current window id is: " + parentId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@aria-label='Menu Flight. Website will be opened in new tab']")).click();
		Thread.sleep(3000);
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
