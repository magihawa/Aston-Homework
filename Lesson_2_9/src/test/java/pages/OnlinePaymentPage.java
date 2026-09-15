package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class OnlinePaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By blockTitle = By.xpath(
            "//*[@id='pay-section']//h2[contains(text(),'Онлайн пополнение')]");
    private By logos = By.cssSelector(".pay__partners img");
    private By detailsLink = By.xpath(
            "//*[@id='pay-section']//a[contains(text(),'Подробнее о сервисе')]");

    private By serviceSelect = By.id("pay");
    private By selectedServiceText = By.cssSelector("#pay-section .select__now");
    private By phoneInput = By.id("connection-phone");
    private By sumInput = By.id("connection-sum");
    private By continueButton = By.cssSelector("#pay-connection button[type='submit']");

    public OnlinePaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getBlockTitle() {
        WebElement title = wait.until(
                ExpectedConditions.visibilityOfElementLocated(blockTitle));
        return title.getText();
    }

    public List<WebElement> getLogos() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(logos, 0));
        return driver.findElements(logos);
    }

    public boolean isLogoVisible(String alt) {
        By logo = By.cssSelector(".pay__partners img[alt='" + alt + "']");
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickDetailsLink() {
        wait.until(ExpectedConditions.elementToBeClickable(detailsLink)).click();
    }

    public String getSelectedServiceText() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(selectedServiceText));
        return element.getText();
    }

    public String getSelectedServiceValue() {
        Select select = new Select(driver.findElement(serviceSelect));
        return select.getFirstSelectedOption().getText();
    }

    public void enterPhone(String phone) {
        WebElement input = wait.until(
                ExpectedConditions.visibilityOfElementLocated(phoneInput));
        input.clear();
        input.sendKeys(phone);
    }

    public void enterSum(String sum) {
        WebElement input = driver.findElement(sumInput);
        input.clear();
        input.sendKeys(sum);
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }
}