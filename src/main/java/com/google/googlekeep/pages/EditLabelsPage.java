package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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
