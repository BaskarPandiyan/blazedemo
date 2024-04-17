package org.stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testing.BaseClass;
import org.testing.Registration_PojoClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegisterStepdefinition extends BaseClass {
	Registration_PojoClass po;

	@Given("The user should launch chrome browser and get the url")
	public void the_user_should_launch_chrome_browser_and_get_the_url() {
		chromeBrowser();
		toGetUrl("https://demo.automationtesting.in/Register.html");
		implicitWait();
		maxWindow();
		toGetTitle();
	}

/*	@When("The user enter valid {string} and {string}")
	public void the_user_enter_valid_and(String Firstname, String Lastname) {
		po = new Registration_PojoClass();
		WebElement f_name = po.getFirstName();
		f_name.sendKeys(Firstname);
		// toSendValue(firstName, "Baskar");

		WebElement l_name = po.getLastName();
		l_name.sendKeys(Lastname);
		// toSendValue(lastName, "Pandiyan");
	}

	@When("The user enter valid {string},The user enter valid {string},The user enter valid {string}")
	public void the_user_enter_valid_The_user_enter_valid_The_user_enter_valid(String Address, String emailid,
			String phoneno) {
		WebElement add = po.getAddress();
		// toSendValue(address, "chennai");
		add.sendKeys(Address);

		WebElement email = po.getEmail();
		email.sendKeys(emailid);

		// toSendValue(email, "baskaraeroer@gmail.com");

		WebElement ph = po.getPhoneno();
		ph.sendKeys(phoneno);

	}
	*/

@When("The user enter valid Firstname and")
public void theUserEnterValidFirstnameAnd() {
	po = new Registration_PojoClass();
	WebElement f_name = po.getFirstName();
	toSendValue(f_name, "Baskar");
	
	WebElement l_name = po.getLastName();
	toSendValue(l_name, "Pandiyan");
}

@When("The user enter valid Address,The user enter valid ,The user enter valid phoneno")
public void theUserEnterValidAddressTheUserEnterValidTheUserEnterValidPhoneno() {
	WebElement add = po.getAddress();
	toSendValue(add, "chennai");


	WebElement email = po.getEmail();
    toSendValue(email, "baskaraeroer@gmail.com");

	WebElement ph = po.getPhoneno();
	ph.sendKeys("123456789");
}

	@Then("The user click gender")
	public void the_user_click_gender() {
		po.getMaleBtn().click();

	}

	@Then("The user click Hobbies")
	public void the_user_click_Hobbies() {
		po.getCheckBox_Movie().click();

	}

	@Then("The user select lanuage,skills,country")
	public void the_user_select_lanuage_skills_country() {
		driver.findElement(By.xpath("//div[@id='msdd']")).click();
		WebElement lan_Eng = driver.findElement(By.partialLinkText("English"));
		lan_Eng.click();
		driver.findElement(By.xpath("//label[normalize-space()='Languages']")).click();

		po.getSelect_Skill().click();
		po.getSelect_Skill().click();
		po.getCountry().click();
		po.getIndia().click();

	}

	@Then("The user select date of birth,")
	public void the_user_select_date_of_birth() {
		po.getYearBox().click();
		po.getSelect_Year().click();
		po.getMonth().click();
		po.getSelect_Month().click();
		po.getDayBox().click();
		po.getSelect_date().click();

	}

	@Then("The user should give password and confirm password")
	public void the_user_should_give_password_and_confirm_password() {
		po.getPass().sendKeys("kjhg");
		po.getConfirmPass().sendKeys("kjhg");

	}

	@Then("Click submit button.")
	public void click_submit_button() {
		driver.findElement(By.xpath("//button[@id='submitbtn']")).click();

	}

}
