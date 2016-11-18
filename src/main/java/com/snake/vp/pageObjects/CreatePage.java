package com.snake.vp.pageObjects;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.snake.vp.WebDriverManager;

public class CreatePage {

	private WebElement computerNameField;
	private WebElement introductionDateField;
	private WebElement discontinuationDateField;
	private Select company;

	private WebElement saveButton;
	private WebElement cancelButton;
	private WebElement deleteButton;
	
	private WebDriver driver;

	public CreatePage() {
		super();
		driver = WebDriverManager.getInstance().getDriver();
		if (driver.findElements(By.id("employee_email")).size() == 1) {
			
			this.computerNameField = driver.findElement(By.id("name"));
			this.introductionDateField = driver.findElement(By.id("introduced"));
			this.discontinuationDateField = driver.findElement(By.id("discontinued"));
			
			this.saveButton = driver.findElement(By.cssSelector(".primary"));
			this.deleteButton = driver.findElement(By.cssSelector(".danger"));
			this.cancelButton = driver.findElements(By.cssSelector(".btn")).get(1);
			
		} else {
			throw new RuntimeException("Wrong page, we are not into the Create page");
		}
	}

	public void createPC(String firstName, String lastName, String email, String id, String leaderName,
			String date) {
		try {
			SimpleDateFormat format = new SimpleDateFormat("dd'-'MM'-'yyyy");
			Calendar cal = Calendar.getInstance();
			cal.setTime(format.parse(date));

		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	public WebElement getComputerNameField() {
		return computerNameField;
	}

	public void setComputerNameField(WebElement computerNameField) {
		this.computerNameField = computerNameField;
	}

	public WebElement getDiscontinuationDateField() {
		return discontinuationDateField;
	}

	public void setDiscontinuationDateField(WebElement discontinuationDateField) {
		this.discontinuationDateField = discontinuationDateField;
	}

	public Select getCompany() {
		return company;
	}

	public void setCompany(Select company) {
		this.company = company;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(WebElement saveButton) {
		this.saveButton = saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

	public void setCancelButton(WebElement cancelButton) {
		this.cancelButton = cancelButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}

	public void setDeleteButton(WebElement deleteButton) {
		this.deleteButton = deleteButton;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public void setDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getIntroductionDateField() {
		return introductionDateField;
	}

	public void setIntroductionDateField(WebElement introductionDateField) {
		this.introductionDateField = introductionDateField;
	}
	
	

}
