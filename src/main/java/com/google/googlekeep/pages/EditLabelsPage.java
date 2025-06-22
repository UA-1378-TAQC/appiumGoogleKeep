package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EditLabelsPage extends BaseNotePage {
    private final By createNewLabelField = By.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/input_text\"]");
    private final By submitButton = By.xpath("//android.widget.Button[@content-desc=\"OK\"]");
    private final By listOfLabels = By.xpath("//*[@resource-id=\"com.google.android.keep:id/label_name\"]");

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
        By editButton = By.xpath("//android.widget.FrameLayout[android.widget.EditText[@text='" + labelName + "']]//android.widget.Button[@content-desc='Edit label']");
        waitForElementToBeClickable(editButton).click();

        By deleteButton = By.xpath("//android.widget.Button[@content-desc='Delete label']");
        waitForElementToBeClickable(deleteButton).click();

        By confirmDelete = By.id("android:id/button1");
        waitForDialogAndClick(confirmDelete);
    }

}
