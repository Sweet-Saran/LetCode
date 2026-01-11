package letcode.stepdefintion;

import java.util.Set;

import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import letcode.baseclass.com.BaseClass;
import letcode.pom.CheapAirPOM;

public class CheapAirStepDefinition extends CheapAirPOM {

//	CheapAirStepDefinition() {
//		super();
//	}

	CheapAirPOM cheap;
	
	@Given("Launch the application")
	public void launch_the_application() {
      BaseClass.loadURL("https://www.cheapair.com/");
  	cheap = new CheapAirPOM();
}
	
	@Given("Verify the homepage logo")
	public void verify_the_homepage_logo() throws InterruptedException {
		Thread.sleep(2000);
		cheap.getHomePgLogo().isDisplayed();
	  	}

	@When("Click on the Round trip dropdown and select the one-way")
	public void click_on_the_round_trip_dropdown_and_select_the_one_way() throws InterruptedException {
		Thread.sleep(2000);
		cheap.getTripDropdown().click();
		Thread.sleep(2000);
		cheap.getSelectedRdBtn().click();
		
	}

	@When("Select the from and to cities")
	public void select_the_from_and_to_cities() throws InterruptedException {
		Thread.sleep(2000);
		cheap.getFromCity().sendKeys("MAA");
		Thread.sleep(2000);
		cheap.getToCity().sendKeys("SIN");
	}

	@When("Select the start and end date with timing")
	public void select_the_start_and_end_date_with_timing() throws InterruptedException {
		Thread.sleep(2000);
		BaseClass.jsClick(cheap.getSelectDateAndTime());
//		WebElement selectDateAndTime = cheap.getSelectDateAndTime();
		BaseClass.waitForElement(cheap.specificDate); 
        BaseClass.jsClick(cheap.getSpecifiDate());
//		BaseClass.jsClick(selectDateAndTime);
//		BaseClass.waitForElement(specificDate);
//		BaseClass.jsClick(getSpecifiDate());	
		}
	
	@Then("Click the search flights button")
	public void click_the_search_flights_button() {
		cheap.getClickSearchFlights().click();
	}

	@Then("Validate the resulted flight details")
	public void validate_the_resulted_flight_details() throws InterruptedException {
		
		String parentPg = driver.getWindowHandle();
		Set<String> allPg = driver.getWindowHandles();
//		driver.switchTo().window(windowHandle);
		for (String page : allPg) {
			 if (!page.equals(parentPg)) {
				driver.switchTo().window(page);
			} 
		}	
		BaseClass.waitForElement(results);
		Thread.sleep(2000);
		cheap.getVerifyTheResults().click();
	}
}
