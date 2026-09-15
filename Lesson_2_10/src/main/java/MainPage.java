package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By cookieButton = By.id("cookie-agree");
    private By onlinePaymentTitle = By.xpath(
            "//*[@id='pay-section']//h2[contains(text(),'Онлайн пополнение')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void open() {
        driver.get("https://www.mts.by/");
    }

    public void acceptCookies() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(cookieButton)).click();
        } catch (Exception e) {
        }
    }

    public OnlinePaymentPage goToOnlinePaymentBlock() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(onlinePaymentTitle));
        return new OnlinePaymentPage(driver);
    }
}