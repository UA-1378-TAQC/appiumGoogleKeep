package com.googleKeep.ui;

import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UndoNoteDeletionTest extends BaseTestRunner {
    String title = "Note To Undo Delete - " + System.currentTimeMillis();
    String body = "This note will be restored.";

    @Test
    public void undoNoteDeletion() {
        SoftAssert softAssert = new SoftAssert();
        MainPage keep = new MainPage(driver);

        keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(title)
                .enterBody(body)
                .saveNote();
        keep.waitForNoteToAppear(title);

        keep.findNotesTitle(title);
        keep.deleteNoteByTitle(title);

        WebElement undoButton = driver.findElement(By.xpath("//android.widget.Button[@text='Undo']"));
        undoButton.click();

        softAssert.assertTrue(keep.waitForNoteToAppear(title),
                "Note should reappear after tapping Undo.");
        softAssert.assertTrue(keep.isNoteDisplayed(title),
                "Note should be visible in the main notes list after Undo.");

        softAssert.assertAll();
    }
}