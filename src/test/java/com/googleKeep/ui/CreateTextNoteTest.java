package com.googleKeep.ui;

import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTextNoteTest extends BaseTestRunner {
    @Test
    public void createTextNoteTest() {
        MainPage keep = new MainPage(driver);
        String title = "Test Note Title";
        String body = "sample text";
        keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(title)
                .enterBody(body)
                .saveNote();

        Assert.assertTrue(keep.isNoteDisplayed(title), "Note with title not found!");
        Assert.assertTrue(keep.isNoteBodyDisplayed(body), "Note body not found or not saved!");
    }

}
