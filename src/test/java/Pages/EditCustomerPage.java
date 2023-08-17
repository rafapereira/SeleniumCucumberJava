package Pages;

import Models.Customer;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {

    @FindBy(id="field-customerName")
    WebElement txt_customerName;

    @FindBy(id="field-contactLastName")
    WebElement txt_contactLastName;

    @FindBy(id="field-contactFirstName")
    WebElement txt_contactFirstName;

    @FindBy(id="field-phone")
    WebElement txt_phone;

    @FindBy(id="field-city")
    WebElement txt_city;

    @FindBy(id="field-state")
    WebElement txt_state;

    @FindBy(id="field-postalCode")
    WebElement txt_postalCode;

    @FindBy(id="field-country")
    WebElement txt_country;

    @FindBy(id="field-creditLimit")
    WebElement txt_creditLimit;

    @FindBy(id="form-button-save")
    WebElement btn_formButtonSave;

    private WebDriver driver;

    public EditCustomerPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void editCustomer(Customer customer) throws InterruptedException {
        txt_customerName.clear();
        txt_customerName.sendKeys(customer.getName());

        txt_contactLastName.clear();
        txt_contactLastName.sendKeys(customer.getLastName());

        txt_contactFirstName.clear();
        txt_contactFirstName.sendKeys(customer.getContactFirstName());

        txt_phone.clear();
        txt_phone.sendKeys(customer.getPhone());

        txt_city.clear();
        txt_city.sendKeys(customer.getCity());

        txt_state.clear();
        txt_state.sendKeys(customer.getState());

        txt_postalCode.clear();
        txt_postalCode.sendKeys(customer.getPostalCode());

        txt_country.clear();
        txt_country.sendKeys(customer.getCountry());

        txt_creditLimit.clear();
        txt_creditLimit.sendKeys(customer.getCreditLimit());

        scrollToBottom();

        btn_formButtonSave.click();
    }

    private void scrollToBottom() throws InterruptedException {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(3000);
    }
}
