package com.snake.vp.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.snake.vp.WebDriverManager;

public class ListPCsPage {

	private WebDriver driver;

	private WebElement searchField;
	private WebElement searchButton;
	private WebElement addButton;

	public ListPCsPage() {
		super();
		driver = WebDriverManager.getInstance().getDriver();
		if (!(driver.findElements(By.cssSelector(".computers")).size() >= 1)) {
			throw new RuntimeException("Wrong page, we are not into the login page");
		}

		this.searchField = driver.findElement(By.cssSelector("#searchbox"));
		this.searchButton = driver.findElement(By.cssSelector("#searchsubmit"));
		this.addButton = driver.findElement(By.cssSelector("#add"));
	}

	/**
	 * This method returns a WebElement containing the Employee ID in the list
	 * of Employees, or Null if nothing was found
	 * 
	 * @param pcName
	 * @return
	 */
	public WebElement findPC(String pcName) {
		WebElement result = null;

		// This is the list of elements inside the table
		List<WebElement> computers = driver.findElements(By.cssSelector(".computers tr"));

		// If the list is only one, it is the header and it is a trap
		if (computers.size() > 1) {
			f: for (int i = 1; i <= computers.size(); i++) {
				List<WebElement> computerParts = computers.get(i).findElements(By.cssSelector("td"));
				// Get employee ID and match to param
				if (computerParts.get(0).getText().equalsIgnoreCase(pcName)) {
					result = computers.get(i);
					break f; // No need to continue iterating
				}
			}
		}

		return result;
	}

	public void filterPC(String pcName) {
		this.searchField.clear();
		this.searchField.sendKeys(pcName);
		this.searchButton.click();
	}

	public WebElement filterAndFindPC(String pcName) {
		filterPC(pcName);
		return findPC(pcName);
	}

	public Integer countPC() {
		List<WebElement> computers = driver.findElements(By.cssSelector(".computers tr"));
		return computers.size();
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getSearchField() {
		return searchField;
	}

	public void setSearchField(WebElement searchField) {
		this.searchField = searchField;
	}

	public WebElement getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(WebElement searchButton) {
		this.searchButton = searchButton;
	}

	public WebElement getAddButton() {
		return addButton;
	}

	public void setAddButton(WebElement addButton) {
		this.addButton = addButton;
	}

}
