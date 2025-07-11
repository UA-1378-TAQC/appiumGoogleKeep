package com.google.googlekeep.components.footerEditorComponents;

import com.google.googlekeep.Base;
import com.google.googlekeep.pages.CheckLabelsPage;
import com.google.googlekeep.pages.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ActionComponent extends Base {

    private final By moreOptionsButton = By.xpath("//android.widget.ImageButton[@content-desc='Action']");
    private final By labelsOption = By.xpath("//android.support.v7.widget.RecyclerView[@resource-id='com.google.android.keep:id/bs_list_view']/android.widget.LinearLayout[5]");
    private final By checkboxesLocator = By.xpath("//android.widget.CheckBox[@resource-id='com.google.android.keep:id/checkbox']");
    private final By labelsLocator = By.xpath("//android.widget.TextView[@resource-id='com.google.android.keep:id/label_name']");

    public ActionComponent(AppiumDriver driver) {
        super(driver);
    }

    public ActionComponent openActionsMenu() {
        waitFor(moreOptionsButton).click();
        return this;
    }

    public ActionComponent tapLabelsOption() {
        waitFor(labelsOption).click();
        return this;
    }

    public CheckLabelsPage goToLabelsPage() {
        waitFor(labelsOption).click();
        return new CheckLabelsPage(driver);
    }

    public ActionComponent selectLabel(String labelName) {
        List<WebElement> checkboxes = driver.findElements(checkboxesLocator);
        List<WebElement> labels = driver.findElements(labelsLocator);

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

    public MainPage saveNote() {
        driver.navigate().back();
        return new MainPage(driver);
    }
}