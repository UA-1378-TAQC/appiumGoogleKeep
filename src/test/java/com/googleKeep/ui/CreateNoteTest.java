package com.googleKeep.ui;

import com.google.googlekeep.pages.KeepNotePage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNoteTest extends BaseTestRunner {

    @Test
    public void testCreateSimpleNote() {
        KeepNotePage keep = new KeepNotePage(driver);

        String title = "Test Note Title";
        String body = "This is a test note body.";

        keep.tapAddNote();
        keep.enterTitle(title);
        keep.enterBody(body);
        keep.saveNote();

        Assert.assertTrue(keep.isNoteDisplayed(title), "Note with title not found!");
    }
}
