package com.google.googlekeep.pages;

import com.google.googlekeep.Base;
import com.google.googlekeep.utils.TextUtil;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.android.nativekey.KeyEventMetaModifier;

public abstract class BaseNotePage extends Base {
    private final By tapOutside = By.xpath("//android.view.View[@resource-id=\"com.google.android.keep:id/touch_outside\"]");
    private final By backButton = By.xpath("//android.widget.ImageButton[@content-desc='Open navigation drawer']");
    private final By titleField = By.id("com.google.android.keep:id/editable_title");
    private final By bodyField = By.id("com.google.android.keep:id/edit_note_text");

    protected BaseNotePage(AppiumDriver webDriver) {
        super(webDriver);
    }

    public BaseNotePage saveNote() {
        driver.findElement(backButton).click();
        return this;
    }

    public BaseNotePage enterTitle(String title) {
        driver.findElement(titleField).sendKeys(title);
        return this;
    }

    public BaseNotePage enterBody(String body) {
        WebElement input = driver.findElement(bodyField);
        input.click();
        enterText(body);
        return this;
    }

    public BaseNotePage enterText(String body) {
        AndroidDriver driver = (AndroidDriver) this.driver;
        for (char c : body.toCharArray()) {
            if (Character.isLetterOrDigit(c) || c == ' ') {
                AndroidKey key = TextUtil.getAndroidKey(Character.toLowerCase(c));
                KeyEvent event = new KeyEvent(key);

                if (Character.isUpperCase(c)) {
                    event = event.withMetaModifier(KeyEventMetaModifier.SHIFT_LEFT_ON);
                }

                driver.pressKey(event);
            }
        }
        return this;
    }


}
