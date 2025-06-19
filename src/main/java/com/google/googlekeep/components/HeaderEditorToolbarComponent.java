package com.google.googlekeep.components;

import com.google.googlekeep.Base;
import com.google.googlekeep.modal.LeftSideModal;
import com.google.googlekeep.pages.BaseNotePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HeaderEditorToolbarComponent extends Base {

    private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");
    private final By pinNoteButton = By.id("com.google.android.keep:id/menu_pin");


    public HeaderEditorToolbarComponent(AppiumDriver driver) {
        super(driver);
    }

    public void tapBackButton() {
        driver.findElement(backButton).click();
    }
}
