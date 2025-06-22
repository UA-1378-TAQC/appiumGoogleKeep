package com.google.googlekeep.pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class CheckLabelsPage extends BaseNotePage {

    public CheckLabelsPage(AppiumDriver driver) {
        super(driver);
    }

    public CheckLabelsPage selectLabel(String labelName) {
        By labelCheckbox = By.xpath("//android.widget.TextView[@text='" + labelName + "']/following-sibling::android.widget.CheckBox");
        driver.findElement(labelCheckbox).click();
        return this;
    }

}
