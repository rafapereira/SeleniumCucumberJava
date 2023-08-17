package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerTablePage {

    private WebDriver driver;

    private By txt_country = By.cssSelector(".form-control.searchable-input.floatL[name='country']");

    private By txt_name = By.cssSelector(".form-control.searchable-input.floatL[name='customerName']");

    private By customeTableBody = By.tagName("tbody");

    private By customerTableRow = By.tagName("tr");

    private By customerTableCell = By.tagName("td");

    private By customerTableEditButton = By.cssSelector("a.btn.btn-default.btn-outline-dark");

    public CustomerTablePage(WebDriver driver){
        this.driver = driver;
    }

    public void findCountry(String country){
        driver.findElement(txt_country).sendKeys(country);
    }

    public void findCustomerName(String name){
        driver.findElement(txt_name).sendKeys(name);
    }

    public String getEditedCustomerName(){
        WebElement table = driver.findElement(customeTableBody);
        WebElement firstRow = table.findElements(customerTableRow).get(0);
        WebElement thirdCell = firstRow.findElements(customerTableCell).get(2);
        return thirdCell.getText();
    }

    public void clickOnEditButtonFromCurrentRow(){
        WebElement table = driver.findElement(customeTableBody);
        WebElement firstRow = table.findElements(customerTableRow).get(0);
        WebElement secondCell = firstRow.findElements(customerTableCell).get(1);
        WebElement button = secondCell.findElement(customerTableEditButton);
        button.click();
    }

    public void goToHomePage() throws InterruptedException {
        driver.navigate().to("https://www.grocerycrud.com/v1.x/demo/bootstrap_theme_v5");
    }

}
