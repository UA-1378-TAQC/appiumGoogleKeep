package com.google.googlekeep.components.footerEditorComponents;

import com.google.googlekeep.Base;

import com.google.googlekeep.pages.CheckLabelsPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import com.google.googlekeep.pages.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionComponent extends Base {

    private final By labelsOption = By.xpath("//android.widget.TextView[@text='Labels']\n");

    public ActionComponent(AppiumDriver driver) {
        super(driver);
    }


    public CheckLabelsPage tapLabelsOption() {
        driver.findElement(labelsOption).click();
        return new CheckLabelsPage(driver);
    }

    private final By moreOptionsButton = By.xpath("//android.widget.ImageButton[@content-desc='Action']");
    private final By labelsOption = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.keep:id/bs_list_view']/android.widget.LinearLayout[5]");

    public ActionComponent openActionsMenu() {
        waitFor(moreOptionsButton).click();
        return this;
    }

    public ActionComponent tapLabelsOption() {
        waitFor(labelsOption).click();
        return this;

    }

    public MainPage saveNote() {
        driver.navigate().back();
        return new MainPage(driver);
    }

    public ActionComponent selectLabel(String labelName) {
        List<WebElement> checkboxes = driver.findElements(By.xpath("//android.widget.CheckBox[@resource-id='com.google.android.keep:id/checkbox']"));
        List<WebElement> labels = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/label_name']"));

        for (int i = 0; i < labels.size(); i++) {
            if (labels.get(i).getText().equals(labelName)) {
                WebElement checkbox = checkboxes.get(i);
                if (!checkbox.getAttribute("checked").equals("true")) {
                    checkbox.click();
                }
                break;
            }
        }
        return this;
    }

}
