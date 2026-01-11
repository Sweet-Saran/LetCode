package letcode.stepdefintion;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.junit.Assert;

import io.cucumber.java.en.*;
import letcode.baseclass.com.BaseClass;
import letcode.pom.LetCodePOM;

public class LetCodeStepDefinition{

    LetCodePOM pom;

    @Given("Launch the application and Verify the homepage Logo")
    public void verify_logo() throws InterruptedException {
    	Thread.sleep(3000);;
        pom = new LetCodePOM(BaseClass.driver);
        Assert.assertTrue(pom.verifyLogo());
    }

    @When("Click on the workspace button")
    public void click_workspace() throws InterruptedException {
    	Thread.sleep(3000);
        pom.clickWorkspace();
    }

    @And("Click on POM option from the list")
    public void click_pom() throws InterruptedException {
    	Thread.sleep(3000);
        pom.clickPOM();
    }

    @Then("Select all the product and iterate the info in output")
    public void iterate_products() throws InterruptedException {
    	Thread.sleep(3000);
        List<WebElement> products = pom.getAllProducts();
        for (WebElement product : products) {
            System.out.println(product.getText());
        }
    }

    @And("After selection verify the product info")
    public void verify_product_info() throws InterruptedException {
    	Thread.sleep(3000);
        List<WebElement> products = pom.getAllProducts();
        for (WebElement product : products) {
            System.out.println(product.isDisplayed());
    }
    }
        @And("Click on the Input option from the list")
        public void click_input_option() throws InterruptedException {
        	Thread.sleep(3000);
        	pom.clickInput();
    }
        
        @Then("Enter the username in the input field")
        public void enter_the_username_in_the_input_field() {
            pom.inputBox();
            
        }

        @Then("Verify the username in the input field")
        public void verify_the_username_in_the_input_field() {
        	pom.verifyInputBox();
        }

}
