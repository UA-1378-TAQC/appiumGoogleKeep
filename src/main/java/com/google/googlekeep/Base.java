package com.google.googlekeep;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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

    protected void type(By locator, String text) {
        WebElement element = waitFor(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return waitFor(locator).getText();
    }
}
