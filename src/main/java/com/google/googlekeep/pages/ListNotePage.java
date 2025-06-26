package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ListNotePage extends BaseNotePage {
    private final By listItemInput = By.id("com.google.android.keep:id/description");
    private final By checklistCheckboxes = By.id("com.google.android.keep:id/checkbox");
    private final By listOptionsButton = By.id("com.google.android.keep:id/list_actions");
    private final By addListItemButton = By.id("com.google.android.keep:id/list_footer_container");
    private final By allListItems = By.xpath("//android.widget.EditText[@resource-id='com.google.android.keep:id/description']");
    private final By markItem = By.xpath("(//android.widget.CheckBox[@resource-id=\"com.google.android.keep:id/checkbox\"])[1]");
    private final By markedItem = By.xpath("//android.widget.CheckBox[@resource-id=\"com.google.android.keep:id/checkbox\"])[3]");
    private final By markedData = By.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/description\" and @text=\"Test1\"]");
    private final By allGrabbers = By.id("com.google.android.keep:id/grabber");

    public ListNotePage(AppiumDriver driver) {
        super(driver);
    }

    public ListNotePage addListItem() {
        tap(addListItemButton);
        return this;
    }

    public ListNotePage enterListItem(String itemText) {
        List<WebElement> inputs = driver.findElements(listItemInput);
        if (!inputs.isEmpty()) {
            WebElement activeInput = inputs.get(inputs.size() - 1);
            activeInput.click();
            enterText(itemText);
        }
        return this;
    }

    public ListNotePage reorderElements(int fromIndex, int toIndex) {
        List<WebElement> inputs = driver.findElements(allGrabbers);
        swipeFromElementToElement(inputs.get(fromIndex),inputs.get(toIndex));

        return this;
    }

    public int getItemCount() {
        return driver.findElements(allListItems).size();
    }

    public String getItemText(int itemIndex) {
        List<WebElement> items = driver.findElements(allListItems);
        if (itemIndex < items.size()) {
            return items.get(itemIndex).getText();
        }
        return "";
    }

    public void markItemInCheckList()
    {
        driver.findElement(markItem).click();
    }

    public String getMarkedData()
    {
        List<WebElement> items = driver.findElements(allListItems);
        return items.get(2).getText();
    }
}
