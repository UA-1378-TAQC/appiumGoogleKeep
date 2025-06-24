package com.google.googlekeep.modal;

import com.google.googlekeep.Base;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchModal extends Base {

    private final By exitButton = By.id("com.google.android.keep:id/search_actionbar_back_button");

    private final By searchLabel = By.id("com.google.android.keep:id/search_actionbar_query_text");

    private final By searchNames = By.id("com.google.android.keep:id/index_note_title");

    public SearchModal(AppiumDriver driver) {
        super(driver);
    }

    public SearchModal enterText(String text) {
        driver.findElement(searchLabel).sendKeys(text);
        return this;
    }

    public List<String> getFoundedNames(){
        var list = new ArrayList<String>();

        var webList = driver.findElements(searchNames);

        for (var element : webList){
            list.add(element.getText());
        }

        return list;
    }

    public void exit(){
        driver.findElement(exitButton).click();
    }
}
