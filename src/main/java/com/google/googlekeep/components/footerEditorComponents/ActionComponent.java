package com.google.googlekeep.components.footerEditorComponents;

import com.google.googlekeep.Base;
import com.google.googlekeep.pages.CheckLabelsPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class ActionComponent extends Base {

    private final By labelsOption = By.xpath("//android.widget.TextView[@text='Labels']\n");

    public ActionComponent(AppiumDriver driver) {
        super(driver);
    }

    public CheckLabelsPage tapLabelsOption() {
        driver.findElement(labelsOption).click();
        return new CheckLabelsPage(driver);
    }
}
