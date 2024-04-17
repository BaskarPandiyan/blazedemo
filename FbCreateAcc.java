package org.stepdefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testing.BaseClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FbCreateAcc extends BaseClass {
	@Given("user open chrome browser")
	public void userOpenChromeBrowser() {
		chromeBrowser();
		maxWindow();
		implicitWait();
		toGetTitle();
	}

	@Given("To Enter FaceBook Url")
	public void toEnterFaceBookUrl() {
		toGetUrl("https://www.facebook.com/");

	}

	@When("Click NewAc Btn")
	public void clickNewAcBtn() throws InterruptedException {
		implicitWait();
		
		driver.findElement(By.xpath("//a[text()='Create new account']")).click();
		Thread.sleep(5000);
	}

	@Then("user enter F.name,L.name,MobileNo,Password")
	public void userEnterFNameLNameMobileNoPassword(io.cucumber.datatable.DataTable dataTable) {
		WebElement f_Name = driver.findElement(By.xpath("//input[@name='firstname']"));
		List<String> asList = dataTable.asList();
		f_Name.sendKeys(asList.get(0));
		
		WebElement l_name = driver.findElement(By.xpath("(//input[@type='text'])[3]"));
		l_name.sendKeys(asList.get(2));
		
		List<List<String>> asLists = dataTable.asLists();
		WebElement mobi_No = driver.findElement(By.xpath("(//input[@type='text'])[4]"));
		mobi_No.sendKeys(asLists.get(0).get(2));
		
		WebElement textBox_passw = driver.findElement(By.xpath("(//input[@type='password'])[2]"));
		textBox_passw.sendKeys(asLists.get(0).get(3));
		
		
		
	}
	
	

}
