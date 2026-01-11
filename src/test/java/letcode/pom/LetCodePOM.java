package letcode.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.junit.Assert;

public class LetCodePOM {

    WebDriver driver;

    public LetCodePOM(WebDriver driver) {
        this.driver = driver;
    }

    By logo = By.xpath("//img[@alt='letcode']");
    By workSpace = By.xpath("//a[text()='Work-Space']");
    By pom = By.xpath("//a[normalize-space()='Page Object Model']");
    By products = By.xpath("//div[@class='columns mt-3 is-multiline']//p[@class='card-header-title']");
    By input = By.xpath("//a[normalize-space()='Edit']");
    By inputbox = By.xpath("//input[@id='fullName']");

    public boolean verifyLogo() {
        return driver.findElement(logo).isDisplayed();
    }

    public void clickWorkspace() {
        driver.findElement(workSpace).click();
    }

    public void clickPOM() {
        driver.findElement(pom).click();
    }

    public List<WebElement> getAllProducts() {
            return driver.findElements(products);
        }
    
    public void clickInput() {
        driver.findElement(input).click();
    }
   
    public void inputBox() {
    	WebElement element = driver.findElement(inputbox);
    	element.clear();
    	element.sendKeys("Poornima");
}
    public void verifyInputBox() {
    	WebElement element = driver.findElement(inputbox);
    	element.clear();
    	element.sendKeys("Poornima");
    	Assert.assertEquals(element.getAttribute("value"), "Poornima");
    	System.out.println("Input Text value:: " + element.getAttribute("value"));
}
}  
