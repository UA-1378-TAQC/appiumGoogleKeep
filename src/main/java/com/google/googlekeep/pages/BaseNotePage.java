package com.google.googlekeep.pages;

import com.google.googlekeep.Base;
import com.google.googlekeep.components.FooterEditorToolbarComponent;
import com.google.googlekeep.components.HeaderEditorToolbarComponent;
import com.google.googlekeep.modal.LeftSideModal;
import com.google.googlekeep.utils.TextUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.nativekey.KeyEventMetaModifier;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public abstract class BaseNotePage extends Base {

    private HeaderEditorToolbarComponent headerEditorToolbarComponent;
    private FooterEditorToolbarComponent footerEditorToolbarComponent;
    private LeftSideModal leftSideModal;
    private final By tapOutside = By.xpath("//android.view.View[@resource-id=\"com.google.android.keep:id/touch_outside\"]");
    private final By titleField = By.id("com.google.android.keep:id/editable_title");
    private final By bodyField = By.id("com.google.android.keep:id/edit_note_text");
    private final By menuButton = By.xpath("//android.widget.ImageButton[@content-desc='Action']");
    private final By colorPaletteButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Варіанти фону\"]");
    private final By orangeColorOption = By.xpath("//android.widget.FrameLayout[@content-desc=\"Колір: Персик\"]");
    private final By deleteButton = By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/menu_text\" and @text=\"Видалити\"]");

    public BaseNotePage(AppiumDriver driver) {
        super(driver);
        this.headerEditorToolbarComponent = new HeaderEditorToolbarComponent(driver);
        this.footerEditorToolbarComponent = new FooterEditorToolbarComponent(driver);
    }

    public MainPage saveNote() {
        headerEditorToolbarComponent.tapBackButton();
        return new MainPage(driver);
    }

    public BaseNotePage enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
        return this;
    }

    public BaseNotePage enterBody(String body) {
        WebElement input = driver.findElement(bodyField);
        input.click();
        enterText(body);
        return this;
    }

    public BaseNotePage enterText(String body) {
        AndroidDriver driver = (AndroidDriver) this.driver;
        for (char c : body.toCharArray()) {
            if (!Character.isLetterOrDigit(c) && c != ' ' && !isSupportedSymbol(c)) {
                continue;
            }

            AndroidKey key = TextUtil.getAndroidKey(c);
            KeyEvent event = new KeyEvent(key);

            if (requiresShift(c)) {
                event = event.withMetaModifier(KeyEventMetaModifier.SHIFT_LEFT_ON);
            }

            driver.pressKey(event);
        }
        return this;
    }

    private boolean isSupportedSymbol(char c) {
        return ",.@#!?:;'\"-_+=/\\\\".indexOf(c) >= 0;
    }

    private boolean requiresShift(char c) {
        return Character.isUpperCase(c) || "!?:\"_+=@#".indexOf(c) >= 0;
    }

    public BaseNotePage archiveNote() {
        headerEditorToolbarComponent.tapArchiveButton();
        return this;
    }

    public BaseNotePage unarchiveNote() {
        headerEditorToolbarComponent.tapUnarchiveButton();
        return this;
    }


    public LeftSideModal tapBurgerButton() {
        leftSideModal.tapNotesButton();
        return new LeftSideModal(driver);
    }

    public ArchivePage tapBachOnArchive() {
        headerEditorToolbarComponent.tapBackButton();
        return new ArchivePage(driver);
    }

    public BaseNotePage openColorPalette() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(colorPaletteButton)).click();
        return this;
    }

    public BaseNotePage selectOrangeColor() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(orangeColorOption)).click();
        return this;
    }

    public BaseNotePage tapOutsideToClosePalette() {
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.visibilityOfElementLocated(tapOutside)).click();
        return this;
    }

    public MainPage deleteNote(){
        driver.findElement(menuButton).click();
        driver.findElement(deleteButton).click();
        return new MainPage(driver);
    }

    public FooterEditorToolbarComponent getFooterEditorToolbarComponent() {
        return footerEditorToolbarComponent;
    }
}
