package com.google.googlekeep;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class Base {
    protected AppiumDriver driver;
    protected WebDriverWait wait;

    public Base(AppiumDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    protected WebElement waitFor(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void click(By locator) {
        waitFor(locator).click();
    }

    protected boolean waitUntilTextAppearsInList(By locator, String expectedText, int timeoutSeconds) {
        try {
            WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
            return customWait.until(d -> {
                List<WebElement> elements = d.findElements(locator);
                return elements.stream().anyMatch(el -> expectedText.equals(el.getText()));
            });
        } catch (TimeoutException e) {
            return false;
        }
    }

    protected boolean waitUntilTextAppearsInList(By locator, String expectedText) {
        return waitUntilTextAppearsInList(locator, expectedText, 10);
    }

}
