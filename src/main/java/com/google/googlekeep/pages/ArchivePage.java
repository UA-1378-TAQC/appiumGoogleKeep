package com.google.googlekeep.pages;

import com.google.googlekeep.modal.LeftSideModal;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ArchivePage extends BaseNotePage {
    private final By listOfNotesTitle = By.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/index_note_title']");
    private final By burgerButtonA = By.id("android.widget.ImageButton");
    private final By gotItButton = By.id("android:id/button1");

    public ArchivePage(AppiumDriver driver) {
        super(driver);
    }

    public void findArchivedNoteByTitle(String targetNote) {
        List<WebElement> notes = driver.findElements(listOfNotesTitle);
        notes.stream()
                .filter(note -> note.getText().equals(targetNote))
                .findFirst()
                .ifPresent(WebElement::click);
    }
    public LeftSideModal tapBurgerButtonA() {
        driver.findElement(burgerButtonA).click();
        return new LeftSideModal(driver);
    }

    public ArchivePage tapGotItButton() {
        driver.findElement(gotItButton).click();
        return this;
    }

}
