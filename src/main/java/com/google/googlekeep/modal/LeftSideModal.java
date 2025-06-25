package com.google.googlekeep.modal;

import com.google.googlekeep.Base;
import com.google.googlekeep.pages.ArchivePage;
import com.google.googlekeep.pages.EditLabelsPage;
import com.google.googlekeep.pages.LabelNotesPage;
import com.google.googlekeep.pages.MainPage;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

public class LeftSideModal extends Base {
    private final By notesButton = By.id("com.google.android.keep:id/drawer_navigation_active");
    private final By createNewLabelButton = By.xpath("//android.widget.TextView[@resource-id=\"com.google.android.keep:id/drawer_create_label_button\"]");
    private final By allNotesButton = By.xpath("""
//android.widget.TextView[@resource-id="com.google.android.keep:id/title" and @text="Notes"]
            """);
    private By editButton(String labelName){
        return By.xpath(String.format("""
//android.widget.TextView[@resource-id="com.google.android.keep:id/title" and @text="%s"]
                """,labelName));
    }

    private final By archiveButton = By.id("com.google.android.keep:id/drawer_navigation_archive");

    public LeftSideModal(AppiumDriver driver) {
        super(driver);
    }

    public EditLabelsPage tapCreateNewLabelButton() {
        driver.findElement(createNewLabelButton).click();
        return new EditLabelsPage(driver);
    }

    public ArchivePage tapArchiveButton() {
        driver.findElement(archiveButton).click();
        return new ArchivePage(driver);
    }

    public MainPage tapNotesButton() {
        driver.findElement(notesButton).click();
        return new MainPage(driver);
    }

    public MainPage selectLabelFromSidebar(String labelName) {
        String xpath = String.format("//android.widget.TextView[@resource-id='com.google.android.keep:id/title' and @text='%s']", labelName);
        driver.findElement(By.xpath(xpath)).click();
        return new MainPage(driver);
    }

    public LabelNotesPage tapLabelButton(String labelName){
        driver.findElement(editButton(labelName)).click();
        return new LabelNotesPage(driver);
    }

    public MainPage tapAllNotesButton(){
        driver.findElement(allNotesButton).click();
        return new MainPage(driver);
    }

}
