package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;


public class ListNotePage {
    private final AppiumDriver driver;

    private final By listItemInput = By.id("com.google.android.keep:id/description");
    private final By checklistCheckboxes = By.id("com.google.android.keep:id/checkbox");
    private final By listOptionsButton = By.id("com.google.android.keep:id/list_actions");
    private final By addListItemButton = By.id("com.google.android.keep:id/list_footer_container");

    public ListNotePage(AppiumDriver driver) {
        this.driver = driver;
    }


    public void addListItem() {
        driver.findElement(addListItemButton).click();
    }

    public void enterListItem(String itemText) {
        driver.findElement(listItemInput).click();
        driver.findElement(listItemInput).sendKeys(itemText);
    }

}
