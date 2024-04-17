package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testing.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlazeDemo extends BaseClass {

	@Given("launch chrome browser and get url")
	public void launchChromeBrowserAndGetUrl() {
		chromeBrowser();
		toGetUrl("https://blazedemo.com/index.php");
		maxWindow();
		implicitWait();
		toGetTitle();

	}

	@When("I click the link open new window and back to home page")
	public void iClickTheLinkOpenNewWindowAndBackToHomePage() {
		driver.findElement(By.partialLinkText("destination of the week! The Beach!")).click();
		driver.navigate().back();

	}

	@When("select mexico city from departure")
	public void selectMexicoCityFromDeparture() {
		WebElement city_Depature = driver.findElement(By.xpath("//select[@name='fromPort']"));

		Select dw = new Select(city_Depature);
		dw.selectByVisibleText("Mexico City");

	}

	@Then("select london from destination")
	public void selectLondonFromDestination() {
		WebElement city_Destinationn = driver.findElement(By.xpath("//select[@name='toPort']"));

		Select se = new Select(city_Destinationn);
		se.selectByVisibleText("London");

	}

	@Then("click tickets and select lowest price ticket")
	public void clickTicketsAndSelectLowestPriceTicket() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.xpath("(//input[@type='submit'])[3]")).click();

	}

	@Then("purchase flight ticket")
	public void purchaseFlightTicket() {
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}

	@Then("store the purchase id in console")
	public void storeThePurchaseIdInConsole() {
		String text_id = driver.findElement(By.tagName("td")).getText();
		System.out.println("Purchase id:" + text_id);
		

	}

}
