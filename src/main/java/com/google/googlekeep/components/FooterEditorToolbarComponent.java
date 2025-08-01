package com.google.googlekeep.components;

import com.google.googlekeep.Base;
import com.google.googlekeep.components.footerEditorComponents.ActionComponent;
import com.google.googlekeep.components.footerEditorComponents.AddComponent;
import com.google.googlekeep.components.footerEditorComponents.ColorComponent;
import com.google.googlekeep.components.footerEditorComponents.FormatingComponent;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class FooterEditorToolbarComponent extends Base {
    private ActionComponent actionComponent;
    private AddComponent addComponent;
    private ColorComponent colorComponent;
    private FormatingComponent formatingComponent;

    public FooterEditorToolbarComponent(AppiumDriver driver) {
        super(driver);
        this.actionComponent = new ActionComponent(driver);
        this.addComponent = new AddComponent(driver);
        this.colorComponent = new ColorComponent(driver);
        this.formatingComponent = new FormatingComponent(driver);
    }

    public ActionComponent openActionMenu() {
        By menuButton = By.xpath("//android.widget.ImageButton[@content-desc='Action']");
        driver.findElement(menuButton).click();
        return actionComponent;
    }

}
