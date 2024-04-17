package org.stepdefinition;

import java.awt.List;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testing.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class FlipkartStepdef extends BaseClass {

	@Given("user Launch Chrome Browser and launch Flipkart website")
	public void user_Launch_Chrome_Browser_and_launch_Flipkart_website() {
		chromeBrowser();
		maxWindow();
		implicitWait();
		driver.get("https://www.flipkart.com/");
		System.out.println("Flipkart website launched");

	}

	@When("The user search {string}")
	public void the_user_search(String string) throws InterruptedException {
		implicitWait();
		WebElement search_Btn = driver.findElement(By.className("Pke_EE"));
		search_Btn.sendKeys("smart tv");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		System.out.println("Smart tv search completed");
		driver.findElement(By.xpath("//div[contains(text(),'Mi X Series 108 cm ')]")).click();
		System.out.println("1st item clicked");

	}

	@When("To click add to cart the item button")
	public void to_click_add_to_cart_the_item_button() throws InterruptedException {
		implicitWait();
		String parentId = driver.getWindowHandle();
		System.out.println("parent window: " + parentId);

		Set<String> allId = driver.getWindowHandles();
		System.out.println("\nallid: " + allId);

		for (String id1 : allId) {
			if (!id1.equals(parentId)) {
				driver.switchTo().window(id1);
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[normalize-space()='Add to cart']")).click();
		System.out.println("Add to cart completed");

	}

	@When("take screenshot")

	public void take_screenshot() throws IOException {
		implicitWait();
		ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		dest = new File("C:\\Users\\MY PC\\eclipse-workspace\\EcomercePro\\Screenshot\\fk.png");
		FileUtils.copyFile(file, dest);

	}

}
