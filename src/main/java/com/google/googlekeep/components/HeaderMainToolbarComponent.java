package com.google.googlekeep.components;

import com.google.googlekeep.Base;
import com.google.googlekeep.modal.LeftSideModal;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HeaderMainToolbarComponent extends Base {

    private final By burgerButton = By.xpath("//android.widget.ImageButton[@content-desc=\"Open navigation drawer\"]");

    public HeaderMainToolbarComponent(AppiumDriver driver) {
        super(driver);
    }

    public LeftSideModal openBurgerButtonModal(){
        driver.findElement(burgerButton).click();
        return new LeftSideModal(driver);
    }
}
