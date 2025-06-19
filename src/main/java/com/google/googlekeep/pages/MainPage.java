package com.google.googlekeep.pages;

import com.google.googlekeep.components.HeaderEditorToolbarComponent;
import com.google.googlekeep.components.HeaderMainToolbarComponent;
import com.google.googlekeep.components.PlusButtonComponent;
import com.google.googlekeep.components.SearchInputComponent;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BaseNotePage {
    private final AppiumDriver driver;
    private final PlusButtonComponent plusButton;
    private SearchInputComponent searchInput;
    private final HeaderMainToolbarComponent headerMainToolbarComponent;

    private final By cancelButton = By.id("android:id/button2");
    private final By listOfNotesTitle = By.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title']");
    private final By skipWelcomeButton = By.id("com.google.android.keep:id/skip_welcome");

    public MainPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        plusButton = new PlusButtonComponent(driver);
        headerMainToolbarComponent = new HeaderMainToolbarComponent(driver);
    }

    public PlusButtonComponent tapAddButtonOnMain() {
        plusButton.tapAddButton();
        return plusButton;
    }

    public void findNotesTitle(String targetNote) {
        List<WebElement> notes = driver.findElements(listOfNotesTitle);
        notes.stream()
                .filter(note -> note.getText().equals(targetNote))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    public boolean waitForNoteToAppear(String titleText) {
        try {
            waitFor(By.xpath("//android.widget.TextView[@text='" + titleText + "']"));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public MainPage skipWelcome() {
        driver.findElement(skipWelcomeButton).click();
        return this;
    }

    public MainPage tapCancelButton() {
        List<WebElement> elements = driver.findElements(cancelButton);
        if (!elements.isEmpty()) {
            elements.get(0).click();
        }
        return this;
    }

    public boolean isNoteDisplayed(String titleText) {
        return !driver.findElements(By.xpath("//android.widget.TextView[@text='" + titleText + "']")).isEmpty();
    }

    public HeaderMainToolbarComponent tapMenuBurgerButton() {
        return headerMainToolbarComponent;
    }

    public boolean isNoteBodyDisplayed(String bodyText) {
        return !driver.findElements(
                By.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_text_description' and  @text='" + bodyText + "']")
        ).isEmpty();
    }

}
