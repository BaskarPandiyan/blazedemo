package org.stepdefinition;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testing.BaseClass;
import org.testing.Registration_PojoClass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testing.Registration_PojoClass;

public class DemoQaMap extends BaseClass {
	Registration_PojoClass po;

	@Given("Open Chrome Browser and get url")
	public void open_Chrome_Browser_and_get_url() {
		chromeBrowser();
		toGetUrl("https://demo.automationtesting.in/Register.html");
		implicitWait();
		maxWindow();
		toGetTitle();

	}

	@When("The user Enter Firstname")
	// 2 Dimensional
	public void the_user_Enter_Firstname(io.cucumber.datatable.DataTable dataTable) {
		po = new Registration_PojoClass();
		WebElement f_name = po.getFirstName();
		List<Map<String, String>> asMaps = dataTable.asMaps();
		f_name.sendKeys(asMaps.get(2).get("Firstname3"));

	}

	@When("Enter Adress")
	// one dimensional
	public void enter_Adress(io.cucumber.datatable.DataTable dataTable) {
		po = new Registration_PojoClass();
		WebElement address = po.getAddress();
		Map<String, String> asMap = dataTable.asMap(String.class, String.class);
		address.sendKeys(asMap.get("Address1"));
		
		
		
	}

}
