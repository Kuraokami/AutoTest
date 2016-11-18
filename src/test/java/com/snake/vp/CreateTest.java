package com.snake.vp;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

import com.snake.vp.pageObjects.ListPCsPage;

public class CreateTest {

	@Test
	public void createPC() {
		// Open the login page
		WebDriverManager.getInstance().navigate();

		ListPCsPage list = new ListPCsPage();
		
		list.filterPC("Fred");
		
		Assert.assertTrue(list.countPC() >= 1);		
	}

	@AfterSuite
	public void tearDown() {
		WebDriverManager.getInstance().getDriver().close();

	}
}
