package com.googleKeep.ui;

import com.google.googlekeep.pages.MainPage;
import com.google.googlekeep.pages.BaseNotePage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ApplyOrangeThemeToNoteTest extends BaseTestRunner {

    @Test
    public void applyOrangeThemeToNoteAndVerify() {

        String noteTitle = "Orange Note - " + System.currentTimeMillis();
        String noteBody = "This note should be orange.";

        BaseNotePage baseNotePage = keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(noteTitle)
                .enterBody(noteBody);

        baseNotePage.openColorPalette()
                .selectOrangeColor()
                .tapOutsideToClosePalette();

        MainPage mainPageAfterSave = baseNotePage.saveNote();

        Assert.assertTrue(mainPageAfterSave.isNoteDisplayed(noteTitle),
                "ERROR: Note '" + noteTitle + "' was NOT displayed on Main Page after applying orange theme.");
    }
}