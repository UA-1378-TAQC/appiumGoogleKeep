package com.google.googlekeep.components;

import com.google.googlekeep.Base;
import com.google.googlekeep.modal.LeftSideModal;
import com.google.googlekeep.pages.BaseNotePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HeaderEditorToolbarComponent extends Base {

    private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");
    private final By closeEditor = By.xpath("//android.view.ViewGroup[@resource-id=\"com.google.android.keep:id/editor_bottom_bar\"]");
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
