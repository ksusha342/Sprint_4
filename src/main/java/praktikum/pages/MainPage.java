package praktikum.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static praktikum.pages.Locators.*;

public class MainPage {

    final String MAIN_PAGE_URL = "https://qa-scooter.praktikum-services.ru";
    final int DEFAULT_WAIT_INTERVAL = 3;
    final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public MainPage open() {
        driver.get(MAIN_PAGE_URL);
        return this;
    }

    public OrderPage clickOrderButton(OrderButtonPosition position) {
        switch (position) {
            case top:
                clickTopOrderButton();
                break;
            case bottom:
                clickBottomOrderButton();
                break;
        }
        return new OrderPage(driver);
    }

    private void clickTopOrderButton() {
        driver.findElement(TOP_ORDER_BUTTON).click();
    }

    private void clickBottomOrderButton() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(BOTTOM_ORDER_BUTTON));
        driver.findElement(BOTTOM_ORDER_BUTTON).click();
    }

    public MainPage clickOnAccordionElementBy(Integer index) {
        By locator = getAccordionElementLocatorBy(index);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
        driver.findElement(locator).click();
        return this;
    }
    public void waitOpenAccordionContent(Integer index) {
        new WebDriverWait(driver, Duration.ofSeconds(DEFAULT_WAIT_INTERVAL))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//div[@id='accordion__panel-" + index + "']")));
    }

    public String getAccordionContentBy(Integer index) {
        return driver.findElement(getAccordionContentLocatorBy(index)).getText();
    }

    private By getAccordionElementLocatorBy(Integer index) {
        return By.xpath(".//div[@id='accordion__heading-" + index + "']");
    }

    private By getAccordionContentLocatorBy(Integer index) {
        return By.xpath(".//div[@id='accordion__panel-" + index + "']");
    }
}