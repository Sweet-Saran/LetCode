package letcode.hook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.protobuf.Duration;

import letcode.baseclass.com.BaseClass;

public class ProjectClassTask extends BaseClass {
//	WebDriver driver;
	
public static String[] xPath = {"175" , "101" , "151"};
static List<String> mrpValue = new ArrayList<String>(Arrays.asList(xPath));

public  enum replacer {REPLACER}; 
public static String REPLACER;
//span[text()='408']/ancestor::div[@class="orc_card"]//button
public static String mrp1 = "//span[text()='"+xPath[0]+"']/ancestor::div[@class='orc_card']//button";

@Ignore
@Test	
public void vodaPhnMRP() {
	BaseClass.launchBrowser();
	BaseClass.loadURL("https://www.myvi.in/prepaid/online-mobile-recharge");
	WebElement element = BaseClass.driver.findElement(By.xpath(mrp1));
	element.click();
	System.out.println(element.getText());
}

@Test
public void pageNation() throws InterruptedException {
	BaseClass.launchBrowser();
	BaseClass.loadURL("https://www.flipkart.com/");
	WebElement searchElement = driver.findElement(By.xpath("//input[@placeholder='Search for Products, Brands and More']"));
	searchElement.click();
	searchElement.clear();
	searchElement.sendKeys("Mobiles" + Keys.ENTER);
	
//	WebElement element = driver.findElement(By.xpath("//a[contains(@class, 'i2eZXn')and text()='10']"));
//	WebElement next = driver.findElement(By.xpath("//span[text()='Next']/parent::a[contains(@class, 'jgg0SZ')]"));

	while (true) {
	    try {
	        List<WebElement> targetPage = driver.findElements(By.xpath("//a[contains(@class, 'i2eZXn') and text()='12']"));
	        
	        if (!targetPage.isEmpty() && targetPage.get(0).isDisplayed()) {
	            Thread.sleep(2000); 
//	        	BaseClass.jsScrolllist(targetPage);
	        	targetPage.get(0).click();
	            System.out.println("Reached Page");
	            break; 
	            
	        } else {
	            WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']/parent::a"));
	            Thread.sleep(2000); 
//	            BaseClass.jsScroll(nextButton);
	            nextButton.click();
	            Thread.sleep(2000); 
	        }
	    } catch (NoSuchElementException e) {
	        System.out.println("Page or Next button not found.");
	        break;
	    }
	}	
}
}
