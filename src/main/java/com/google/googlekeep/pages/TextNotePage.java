package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class TextNotePage extends BaseNotePage{
    private final By titleField = By.id("com.google.android.keep:id/editable_title");
    private final By bodyField = By.id("com.google.android.keep:id/edit_note_text");

    public TextNotePage(AppiumDriver webDriver) {
        super(webDriver);
    }
    public TextNotePage enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
        return this;
    }

    public TextNotePage enterBody(String body) {
        driver.findElement(bodyField).sendKeys(body);
        return this;
    }
}
