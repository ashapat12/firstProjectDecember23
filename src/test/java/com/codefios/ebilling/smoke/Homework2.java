package com.codefios.ebilling.smoke;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Homework2 {

		public static WebDriver driver;

		@Test
		public void test1() {
			// Positive test with correct credentials.
			test("demo@codefios.com", "abc123");
			test("demo@codefios.com", "abc1234");
			
		}

		public void test(String username, String password) {
			driver.findElement(By.name("user_name")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			driver.findElement(By.id("login_submit")).click();
			driver.findElement(By.linkText("List Accounts")).click();
			driver.findElement(By.xpath("//button[text()='Add Account']")).click();
			driver.findElement(By.id("account_name")).sendKeys("December23AP");
			driver.findElement(By.id("balance")).sendKeys("2000");
			driver.findElement(By.id("account_number")).sendKeys("987654");
			driver.findElement(By.id("accountSave")).click();

		}

		@Before
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "drive\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.get("https://codefios.com/ebilling");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		}

		@After
		public void tearDown() throws InterruptedException {
			Thread.sleep(1000);
			driver.close();
		}
}
