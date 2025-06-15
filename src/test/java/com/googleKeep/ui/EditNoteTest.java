package com.googleKeep.ui;

import com.google.googlekeep.pages.KeepNotePage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditNoteTest extends BaseTestRunner {
    @Test
    public void createTextNoteTest() {
        KeepNotePage keep = new KeepNotePage(driver);
        String title = "ExistingNoteTitle";
        String newTitle = "ExistingNoteTitle — Edited";
        keep.skipWelcome()
                .tapCancelButton()
                .tapAddButton()
                .createTextNote()
                .enterTitle(title)
                .saveNote();

        keep.waitForNoteToAppear(title, 3);
        keep.findNotesTitle(title);
        keep.enterTitle(newTitle).saveNote();

        Assert.assertTrue(keep.isNoteDisplayed(newTitle), "Note with title not found!");
    }
}
