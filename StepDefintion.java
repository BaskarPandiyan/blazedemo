package org.stepdefinition;

import org.openqa.selenium.WebElement;
import org.testing.BaseClass;
import org.testing.PojoClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefintion extends BaseClass {
	

	@Given("The user should open the chrome Browser")
	public void the_user_should_open_the_chrome_Browser() throws InterruptedException {
		chromeBrowser();
		toGetUrl("https://www.facebook.com/");
		maxWindow();
		implicitWait();

	}

	@When("The user enter both username and password")
	public void the_user_enter_both_username_and_pw() {
		PojoClass p = new PojoClass();
		WebElement txt_User = p.getTxtUser();
		toSendValue(txt_User, "9597573801");

		WebElement txt_Pass = p.getTxtPass();
		toSendValue(txt_Pass, "skjdfhdakg");

	}

	@When("The user click the login btn")
	public void the_user_click_the_login_btn() {
		PojoClass p = new PojoClass();
		WebElement btn_Login = p.getBtnLogin();
		toClick(btn_Login);
	}

	@Then("The Fb page redirected to Invalid creentials page")
	public void the_Fb_page_redirected_to_Invalid_creentials_page() {

		String current_Url = driver.getCurrentUrl();
		if (current_Url.contains("privacy_mutation_token")) {
			System.out.println("page redirected to invalid credentials page");
			
		} else {
			System.out.println("page does not redirected to invalid credentials page");

		}
	}

}
