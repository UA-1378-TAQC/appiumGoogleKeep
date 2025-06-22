package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.List;

public class EditLabelsPage extends BaseNotePage {
    private final By createNewLabelField = By.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/input_text\"]");
    private final By submitButton = By.xpath("//android.widget.Button[@content-desc=\"OK\"]");
    private final By listOfLabels = By.xpath("//*[@resource-id=\"com.google.android.keep:id/label_name\"]");
    private final By labelEntryContainer = By.id("com.google.android.keep:id/label_editor_entry_root");
    private final By labelEditButton = By.id("com.google.android.keep:id/pencil");
    private final By deleteLabelButton = By.xpath("//android.widget.Button[@content-desc='Delete label']");
    private final By confirmDeleteButton = By.id("android:id/button1");

    public EditLabelsPage(AppiumDriver driver) {
        super(driver);
    }

    public EditLabelsPage enterNewLabelName(String labelName) {
        driver.findElement(createNewLabelField).click();
        enterText(labelName);
        return this;
    }

    public EditLabelsPage clickSubmit() {
        driver.findElement(submitButton).click();
        return this;
    }

    public boolean waitForLabelToAppear(String labelName) {
        return waitUntilTextAppearsInList(listOfLabels, labelName, 10);
    }


    public void deleteLabel(String labelName) {
        System.out.println("Search for a block with a label:" + labelName);
        List<WebElement> labelContainers = driver.findElements(labelEntryContainer);

        for (WebElement container : labelContainers) {
            try {
                WebElement labelText = container.findElement(listOfLabels);
                if (labelText.getText().equals(labelName)) {
                    WebElement pencilButton = container.findElement(labelEditButton);
                    pencilButton.click();

                    waitForElementToBeClickable(deleteLabelButton).click();
                    waitForElementToBeClickable(confirmDeleteButton).click();

                    System.out.println("✅ Label '" + labelName + "' deleted.");
                    return;
                }
            } catch (Exception ignored) {
            }
        }

        System.out.println("❌ No label or icon found for: " + labelName);
        throw new NoSuchElementException("Label not found: " + labelName);

    public boolean isLabelPresent(String labelName) {
        List<WebElement> labels = driver.findElements(listOfLabels);
        for (WebElement label : labels) {
            if (label.getText().equalsIgnoreCase(labelName)) {
                return true;
            }
        }
        return false;

    }
}
