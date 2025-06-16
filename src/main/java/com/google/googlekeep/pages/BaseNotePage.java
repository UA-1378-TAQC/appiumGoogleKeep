package com.google.googlekeep.pages;

import com.google.googlekeep.Base;
import com.google.googlekeep.components.FooterEditorToolbarComponent;
import com.google.googlekeep.components.HeaderEditorToolbarComponent;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BaseNotePage extends Base {
    private WebElement title;
    private HeaderEditorToolbarComponent headerEditorTollBArComponent;
    private FooterEditorToolbarComponent footerEditorToolbarComponent;
    private final By tapOutside = By.xpath("//android.view.View[@resource-id=\"com.google.android.keep:id/touch_outside\"]");
    private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");

    protected BaseNotePage(AppiumDriver webDriver) {
        super(webDriver);
    }

    public BaseNotePage tapOutside() {
        return this;
    }

    public BaseNotePage saveNote() {
        driver.findElement(backButton).click();
        return this;
    }

}
