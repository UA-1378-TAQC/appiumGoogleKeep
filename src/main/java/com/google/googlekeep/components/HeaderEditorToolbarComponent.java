package com.google.googlekeep.components;

import com.google.googlekeep.Base;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HeaderEditorToolbarComponent extends Base {

    private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Перейти вгору\"]");
    private final By pinButton = By.id("com.google.android.keep:id/menu_pin");
    private final By reminderButton = By.id("com.google.android.keep:id/menu_reminder");
    private final By archiveButton = By.id("com.google.android.keep:id/menu_archive");
    private final By unarchiveButton = By.id("com.google.android.keep:id/menu_unarchive");

    public HeaderEditorToolbarComponent(AppiumDriver driver) {
        super(driver);
    }

    public void tapBackButton() {
        driver.findElement(backButton).click();
    }
    public void tapPinButton() {
        driver.findElement(pinButton).click();
    }
    public void tapReminderButton() {
        driver.findElement(reminderButton).click();
    }
    public void tapArchiveButton() {
        driver.findElement(archiveButton).click();
    }
    public void tapUnarchiveButton() {
        driver.findElement(unarchiveButton).click();
    }
}
