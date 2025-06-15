package com.googleKeep.ui;

import com.google.googlekeep.pages.KeepNotePage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateTextNoteTest extends BaseTestRunner {

    @Test
    public void createTextNoteTest() {
        KeepNotePage keep = new KeepNotePage(driver);
        String title = "Test Note Title";
        String body = "This is a test note body.";
        keep.tapAddButton()
            .createTextNote()
            .enterTitle(title)
            .enterBody(body)
            .saveNote();

        Assert.assertTrue(keep.isNoteDisplayed(title), "Note with title not found!");
    }
}
