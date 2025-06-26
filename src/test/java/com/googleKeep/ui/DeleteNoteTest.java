package com.googleKeep.ui;

import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DeleteNoteTest extends BaseTestRunner {
    @Test
    public void deleteNoteImmediatelyAndVerifyNotDisplayed() {

        String noteTitleToDelete = "Note To Be Deleted - " + System.currentTimeMillis();
        String noteBody = "This note will be deleted.";

        var baseNotePage = keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(noteTitleToDelete)
                .enterBody(noteBody);

        MainPage mainPageAfterDeletion = baseNotePage.deleteNote();

        mainPageAfterDeletion.waitForNoteToDisappear(noteTitleToDelete);

        Assert.assertFalse(mainPageAfterDeletion.isNoteDisplayed(noteTitleToDelete),
                "ERROR: Note '" + noteTitleToDelete + "' is STILL displayed on Main Page after immediate deletion!");

    }
}