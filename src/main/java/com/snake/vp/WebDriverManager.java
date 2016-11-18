package com.snake.vp;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WebDriverManager {
	private static WebDriverManager instance = null;

	public static final String USERNAME = "Snake";
	public static final String ACCESS_KEY = "YOUR_ACCESS_KEY";
	public static final String sauce = "20dd3db0-b571-47b4-a057-0701e3460695"; // Only
																				// for
																				// testing
																				// purposes

	public static final String URL = "https://" + USERNAME + ":" + sauce + "@ondemand.saucelabs.com:443/wd/hub";

	private WebDriver driver;

	protected WebDriverManager() {
		try {
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			caps.setCapability("platform", "Windows XP");
			caps.setCapability("version", "43.0");

			driver = new RemoteWebDriver(new URL(URL), caps);

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.exit(-1);
		}
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
	public void navigate() {
		driver.get("http://computer-database.gatling.io/computers");

	}

	public void navigateToPublicSite() {
		navigate();
		driver.findElement(By.cssSelector("#content > p > a")).click();

	}

}
