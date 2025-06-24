package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.List;

public class EditLabelsPage extends BaseNotePage {
    private final By exitButton = By.xpath("""
//android.widget.ImageButton[@content-desc="Open navigation drawer"]
            """);
    private final By createNewLabelField = By.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/input_text\"]");
    private final By submitButton = By.xpath("//android.widget.Button[@content-desc=\"OK\"]");
    private final By listOfLabels = By.xpath("//*[@resource-id=\"com.google.android.keep:id/label_name\"]");
    private final By labelEntryContainer = By.id("com.google.android.keep:id/label_editor_entry_root");
    private final By labelEditButton = By.id("com.google.android.keep:id/pencil");
    private final By deleteLabelButton = By.xpath("//android.widget.Button[@content-desc='Delete label']");
    private final By confirmDeleteButton = By.id("android:id/button1");
    private final By deleteSubmitButton = By.xpath("""
//android.widget.Button[@resource-id="android:id/button1"]
            """);
    private By editButton(String labelName){
       return
               By.xpath(String.format("""
//android.widget.EditText[@resource-id="com.google.android.keep:id/label_name" and @text="%s"]/../..//android.widget.Button[@content-desc="Edit label"]
                       """,labelName));
    }

    private By deleteButton(String labelName){
        return
                By.xpath(String.format("""
//android.widget.EditText[@resource-id="com.google.android.keep:id/label_name" and @text="%s"]/../..//android.widget.Button[@content-desc="Delete label"] 
                       """,labelName));
    }

    public EditLabelsPage(AppiumDriver driver) {
        super(driver);
    }

    public EditLabelsPage enterNewLabelName(String labelName) {
        driver.findElement(createNewLabelField).sendKeys(labelName);
        return this;
    }

    public EditLabelsPage clickSubmit() {
        driver.findElement(submitButton).click();
        return this;
    }

    public EditLabelsPage clickEditButton(String labelName){
        driver.findElement(editButton(labelName)).click();
        return this;
    }

    public EditLabelsPage clickDeleteButton(String labelName){
        driver.findElement(deleteButton(labelName)).click();
        return this;
    }

    public EditLabelsPage submitDelete(){
        driver.findElement(deleteSubmitButton).click();
        return this;
    }

    public boolean isLabelCreated(String labelName) {
        return waitUntilTextAppearsInList(listOfLabels, labelName, 10);
    }
    public boolean waitForLabelToAppear(String labelName) {
        return waitUntilTextAppearsInList(listOfLabels, labelName, 10);
    }


    public boolean isLabelPresent(String labelName) {
        List<WebElement> labels = driver.findElements(listOfLabels);
        for (WebElement label : labels) {
            if (label.getText().equalsIgnoreCase(labelName)) {
                return true;
            }
        }
        return false;

    }
    public EditLabelsPage createLabel(String labelName){
        enterNewLabelName(labelName).clickSubmit();
        return this;
    }

    public EditLabelsPage deleteLabel(String labelName){
        clickEditButton(labelName).clickDeleteButton(labelName).submitDelete();
        return this;
    }

    public void exit(){
        driver.findElement(exitButton).click();
    }
}
