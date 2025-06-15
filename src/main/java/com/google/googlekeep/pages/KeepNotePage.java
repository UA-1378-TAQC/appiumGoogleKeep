package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class KeepNotePage {
    private final By skipWelcomeButton = By.xpath("//android.widget.Button[@resource-id=\"com.google.android.keep:id/skip_welcome\"]\n");
    private final By plusButton = By.xpath("//com.google.android.material.floatingactionbutton.FloatingActionButton[@content-desc=\"Create a note\"]");
    private final By addNoteButton = By.xpath("//android.widget.ImageButton[@content-desc='New text note']");
    private final By titleField = By.id("com.google.android.keep:id/editable_title");
    private final By bodyField = By.id("com.google.android.keep:id/edit_note_text");
    private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");

    private final AppiumDriver driver;

    public KeepNotePage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void skipWelcome() {
        driver.findElement(skipWelcomeButton).click();
    }

    public void clickAdd() {
        driver.findElement(plusButton).click();
    }

    public void tapAddNote() {
        driver.findElement(addNoteButton).click();
    }

    public void enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
    }

    public void enterBody(String body) {
        driver.findElement(bodyField).sendKeys(body);
    }

    public void saveNote() {
        driver.findElement(backButton).click(); // повертаємось назад — зберігається автоматично
    }

    public boolean isNoteDisplayed(String titleText) {
        return driver.findElements(By.xpath("//android.widget.TextView[@text='" + titleText + "']")).size() > 0;
    }
}
