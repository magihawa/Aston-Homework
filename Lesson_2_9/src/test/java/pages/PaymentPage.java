package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By iframe = By.cssSelector("iframe.payment-widget-iframe");
    private By description = By.cssSelector(".pay-description__text");
    private By cost = By.cssSelector(".pay-description__cost");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isOpened() {
        try {
            wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iframe));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getDescription() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(description));
        return element.getText();
    }

    public String getCost() {
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(cost));
        return element.getText();
    }

    public void backToMainPage() {
        driver.switchTo().defaultContent();
    }
}