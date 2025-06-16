package com.google.googlekeep.components;

import com.google.googlekeep.Base;
import com.google.googlekeep.pages.ListNotePage;
import com.google.googlekeep.pages.MainPage;
import com.google.googlekeep.pages.TextNotePage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class PlusButtonComponent extends Base {
    private final By listNoteButton = By.id("com.google.android.keep:id/new_list_button");
    private final By plusButton = By.id("com.google.android.keep:id/speed_dial_create_close_button");
    private final By textNoteButton = By.id("com.google.android.keep:id/new_note_button");


    public PlusButtonComponent(AppiumDriver webDriver) {
        super(webDriver);
    }
    public PlusButtonComponent tapAddButton() {
        driver.findElement(plusButton).click();
        return this;
    }

    public TextNotePage createTextNote() {
        driver.findElement(textNoteButton).click();
        return new TextNotePage(driver);
    }

    public ListNotePage createListNote() {
        driver.findElement(listNoteButton).click();
        return new ListNotePage(driver);
    }

}
