package com.snake.vp;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {
	private static WebDriverManager instance = null;

	private WebDriver driver;
	protected WebDriverManager() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\bin\\ChromeDriver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public static WebDriverManager getInstance() {
		if (instance == null) {
			instance = new WebDriverManager();
		}
		return instance;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * This method leaves the user into the beginning
	 */
	public void navigate(){
		driver.get("http://computer-database.gatling.io/computers");
		
	}

	public void navigateToPublicSite() {
		navigate();
		driver.findElement(By.cssSelector("#content > p > a")).click();
		
	}
	
	
}
