package com.google.googlekeep.pages;

import com.google.googlekeep.Base;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class EditLabelsPage extends Base {
    private final By createNewLabelField = By.xpath("//android.widget.EditText[@resource-id=\"com.google.android.keep:id/input_text\"]");
    private final By submitButton = By.xpath("//android.widget.Button[@content-desc=\"OK\"]");

    public EditLabelsPage(AppiumDriver driver) {
        super(driver);
    }

    public EditLabelsPage enterNewLabelName(String labelName){
        driver.findElement(createNewLabelField).sendKeys(labelName);
        return this;
    }

    public EditLabelsPage clickSubmit(){
        driver.findElement(submitButton).click();
        return this;
    }

}
