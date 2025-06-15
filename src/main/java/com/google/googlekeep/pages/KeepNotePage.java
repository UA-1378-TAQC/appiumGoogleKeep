package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class KeepNotePage {
    private final By skipWelcomeButton = By.id("com.google.android.keep:id/skip_welcome");
    private final By plusButton = By.id("com.google.android.keep:id/speed_dial_create_close_button");
    private final By textNoteButton = By.id("com.google.android.keep:id/new_note_button");
    private final By titleField = By.id("com.google.android.keep:id/editable_title");
    private final By bodyField = By.id("com.google.android.keep:id/edit_note_text");
    private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");

    private final By cancelButton = By.id("android:id/button2");
    private final By listNoteButton = By.id("com.google.android.keep:id/new_list_button");
    private final By listOfNotesTitle = By.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title']");

    private final AppiumDriver driver;

    public KeepNotePage(AppiumDriver driver) {
        this.driver = driver;
    }


    public void findNotesTitle(String targetNote) {
        List<WebElement> notes = driver.findElements(listOfNotesTitle);
        notes.stream()
                .filter(note -> note.getText().equals(targetNote))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public boolean waitForNoteToAppear(String titleText, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//android.widget.TextView[@text='" + titleText + "']")));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public KeepNotePage skipWelcome() {
        driver.findElement(skipWelcomeButton).click();
        return this;
    }

    public KeepNotePage tapCancelButton() {
        driver.findElement(cancelButton).click();
        return this;
    }

    public KeepNotePage tapAddButton() {
        driver.findElement(plusButton).click();
        return this;
    }

    public KeepNotePage createTextNote() {
        driver.findElement(textNoteButton).click();
        return this;
    }

    public KeepNotePage enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
        return this;
    }

    public KeepNotePage enterBody(String body) {
        driver.findElement(bodyField).sendKeys(body);
        return this;
    }

    public KeepNotePage saveNote() {
        driver.findElement(backButton).click();
        return this;
    }

    public boolean isNoteDisplayed(String titleText) {
        return driver.findElements(By.xpath("//android.widget.TextView[@text='" + titleText + "']")).size() > 0;
    }

    public KeepNotePage createListNote() {
        driver.findElement(listNoteButton).click();
        return this;
    }

}

