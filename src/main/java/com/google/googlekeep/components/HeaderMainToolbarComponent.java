package com.google.googlekeep.components;

import com.google.googlekeep.Base;
import com.google.googlekeep.components.headerMainComponents.SearchInputComponent;
import com.google.googlekeep.components.headerMainComponents.UserProfileComponent;
import com.google.googlekeep.modal.LeftSideModal;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class HeaderMainToolbarComponent extends Base {
    private SearchInputComponent searchInputComponent;
    private UserProfileComponent userProfileComponent;

    private final By burgerButton = By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");
    private final By switchViewButton = By.id("com.google.android.keep:id/menu_switch_to_list_view");

    public HeaderMainToolbarComponent(AppiumDriver driver) {
        super(driver);
    }

    public LeftSideModal openBurgerButtonModal() {
        driver.findElement(burgerButton).click();
        return new LeftSideModal(driver);
    }
}
