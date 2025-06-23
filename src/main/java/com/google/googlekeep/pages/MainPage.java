package com.google.googlekeep.pages;

import com.google.googlekeep.components.*;
import com.google.googlekeep.components.footerEditorComponents.ActionComponent;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MainPage extends BaseNotePage {
    private final PlusButtonComponent plusButton;
    private final HeaderMainToolbarComponent headerMainToolbarComponent;

    private final By cancelButton = By.id("android:id/button2");
    private final By listOfNotesTitle = By.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title']");
    private final By skipWelcomeButton = By.id("com.google.android.keep:id/skip_welcome");

    public MainPage(AppiumDriver driver) {
        super(driver);
        this.plusButton = new PlusButtonComponent(driver);
        this.headerMainToolbarComponent = new HeaderMainToolbarComponent(driver);
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

    public MainPage goToLeftSideModal() {
        headerMainToolbarComponent.openBurgerButtonModal();
        return this;
    }

    public ActionComponent actionComponentMenu() {
        return new ActionComponent(driver);
    }

    public MainPage tapBackArrow() {
        driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")).click();
        return this;
    }

    public boolean verifyLabelPresentOnNote(String noteTitle, String label) {
        try {
            WebElement noteContainer = driver.findElement(By.xpath(
                    "//android.widget.TextView[@text='" + noteTitle + "']/ancestor::*[@resource-id='com.google.android.keep:id/browse_text_note']"
            ));

            return !noteContainer.findElements(By.xpath(".//android.widget.TextView[@text='" + label + "']")).isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    public void deleteNoteByTitle(String title) {
        if (isNoteDisplayed(title)) {
            findNotesTitle(title);
            archiveNote();
        }
    }
}
