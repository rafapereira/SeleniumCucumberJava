package StepDefinitions;

import Models.Customer;
import Pages.CustomerTablePage;
import Pages.EditCustomerPage;
import Utils.CustomerUtils;
import io.cucumber.java.en.*;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class EditSteps {

    WebDriver driver = null;

    Customer customer = Customer.builder().build();

    CustomerTablePage customerTablePage;

    EditCustomerPage editCustomerPage;

    public EditSteps(){
        String projectPath=System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath+"/src/test/resources/Drivers/Chrome/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        this.customerTablePage = new CustomerTablePage(driver);
        this.editCustomerPage = new EditCustomerPage(driver);
    }

    @Given("Im on table page")
    public void im_on_table_page() throws InterruptedException {
        customerTablePage.goToHomePage();
    }

    @When("^I find a customer from (.*)")
    public void i_find_a_customer_from_country(String country) throws InterruptedException {
        customerTablePage.findCountry(country);
    }

    @When("click on edit button of the corresponding row")
    public void click_on_edit_button_of_the_corresponding_row() {
        customerTablePage.clickOnEditButtonFromCurrentRow();
    }

    @When("I edit customer informations")
    public void i_edit_customer_informations() throws InterruptedException {
        customer = CustomerUtils.generateRandomCustomer();

        editCustomerPage.editCustomer(customer);

        Thread.sleep(1000);
    }

    @Then("the customer information changes for the new values")
    public void the_customer_information_changes_for_the_new_values() throws InterruptedException {
        customerTablePage.goToHomePage();
        customerTablePage.findCustomerName(customer.getName());

        assertEquals(customer.getName(), customerTablePage.getEditedCustomerName());
    }

    @After
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
