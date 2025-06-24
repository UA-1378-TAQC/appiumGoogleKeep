package com.google.googlekeep;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
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

    protected void tap(By locator) {
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

    protected void swipeFromElementToElement(WebElement fromElement, WebElement toElement){
        Point fromLocation = fromElement.getLocation();
        Dimension fromSize = fromElement.getSize();
        int startX = fromLocation.getX() + fromSize.getWidth() / 2;
        int startY = fromLocation.getY() + fromSize.getHeight() / 2;

        Point toLocation = toElement.getLocation();
        Dimension toSize = toElement.getSize();
        int endX = toLocation.getX() + toSize.getWidth() / 2;
        int endY = toLocation.getY() + toSize.getHeight() / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 0)
                .addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
                .addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
                .addAction(finger.createPointerMove(Duration.ofMillis(600), PointerInput.Origin.viewport(), endX, endY))
                .addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

}
