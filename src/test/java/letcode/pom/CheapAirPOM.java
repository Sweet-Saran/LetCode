package letcode.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import letcode.baseclass.com.BaseClass;

public class CheapAirPOM extends BaseClass {
	
//	WebDriver driver;
	
	public  By homePgLogo = By.xpath("//div[@class='d-flex flex-row justify-content-end']");
	public  By trip = By.xpath("//div[@id='flights_triptype_label']");
	public  By selectedRdBtn = By.xpath("(//div[text()='One-way'])[last()]//span");
	public  By fromCity = By.xpath("//input[@placeholder='From where?']");
	public  By toCity = By.xpath("//input[@placeholder='To where?']");
	public  By dateAndTime = By.xpath("//input[@id='fs_departDate_0']");
	public  By specificDate = By.xpath("(//div[@class='calendar__single-month active']//span[text()='2'])[1]");
	public  By searchFlights = By.xpath("//input[@id='searchNow']");
	public  By results = By.xpath("(//span[text()='Select']/parent::button)[1]");

//	public CheapAirPOM(){
//	}
	//span[text()='Select']/parent::button)[1]
	
			//button[contains(@aria-label, 'Select this contract of 292 fare and move to Payment Page ')]
	
	public WebElement getHomePgLogo() {
        return driver.findElement(homePgLogo);
    }

    public WebElement getTripDropdown() {
        return driver.findElement(trip);
    }

    public WebElement getSelectedRdBtn() {
        return driver.findElement(selectedRdBtn);
    }

    public WebElement getFromCity() {
        return driver.findElement(fromCity);
    }

    public WebElement getToCity() {
        return driver.findElement(toCity);
    }

    public WebElement getSelectDateAndTime() {
        return driver.findElement(dateAndTime);
    }

    public WebElement getSpecifiDate() {
        return driver.findElement(specificDate);
    }

    public WebElement getClickSearchFlights() {
        return driver.findElement(searchFlights);
    }

    public WebElement getVerifyTheResults() {
    	return BaseClass.waitForElement(results);
//        return driver.findElement(results);
        
    }
}