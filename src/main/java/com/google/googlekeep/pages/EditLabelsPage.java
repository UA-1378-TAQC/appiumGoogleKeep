package com.google.googlekeep.pages;

import dev.failsafe.internal.util.Assert;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EditLabelsPage extends BaseNotePage {
    private final By exitButton = By.xpath("""
//android.widget.ImageButton[@content-desc="Open navigation drawer"]
            """);
    private final By createNewLabelField = By.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/input_text\"]");
    private final By submitButton = By.xpath("//android.widget.Button[@content-desc=\"OK\"]");
    private final By listOfLabels = By.xpath("//*[@resource-id=\"com.google.android.keep:id/label_name\"]");
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
        return waitUntilTextAppearsInList(listOfLabels, labelName);
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
