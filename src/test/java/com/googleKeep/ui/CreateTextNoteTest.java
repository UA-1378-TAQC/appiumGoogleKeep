package com.googleKeep.ui;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;

public class CreateTextNoteTest extends BaseTestRunner {
    @Test
    public void createTextNoteTest() {
        MainPage keep = new MainPage(driver);
        String title = "Test Note Title";
        String body = "Sample text";
        keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(title)
                .enterBody(body)
                .saveNote();

        Assert.assertTrue(keep.isNoteDisplayed(title), "Note with title not found!");
        Assert.assertTrue(keep.isNoteBodyDisplayed(body), "Note body not found or not saved!");
    }
}
