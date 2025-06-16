package com.google.googlekeep.modal;

import com.google.googlekeep.Base;
import com.google.googlekeep.pages.EditLabelsPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LeftSideModal extends Base {
    private final By createNewLabelButton = By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/drawer_create_label_button\"]");
    public LeftSideModal(AppiumDriver driver) {
        super(driver);
    }

    public EditLabelsPage tapCreateNewLabelButton(){
        driver.findElement(createNewLabelButton).click();
        return new EditLabelsPage(driver);
    }

}
