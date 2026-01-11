package letcode.baseclass.com;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BaseClass {

    public static WebDriver driver;

    public static  void launchBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public static void loadURL(String url) {
        driver.get(url);
    }
    
    public static void jsClick(WebElement ele) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].click();", ele);
    }
    
    public static WebElement waitForElement(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static void jsScrolllist(List<WebElement> ele) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
    }

    public static void jsScroll(WebElement ele) {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ele);
    }
    
    public static void scrollToBottom() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        } catch (Exception e) {
            System.out.println("Error while scrolling: " + e.getMessage());
        }
    }

    public static void quitBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
