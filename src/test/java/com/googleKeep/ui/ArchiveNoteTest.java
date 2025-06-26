package com.googleKeep.ui;

import com.google.googlekeep.pages.MainPage;
import com.google.googlekeep.modal.LeftSideModal;
import com.google.googlekeep.pages.ArchivePage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ArchiveNoteTest extends BaseTestRunner {
    String title = "Note To Be Archived - " + System.currentTimeMillis();
    String body = "This note will be archived.";

    @Test
    public void archiveNote() {
        SoftAssert softAssert = new SoftAssert();
        MainPage keep = new MainPage(driver);

        keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(title)
                .enterBody(body)
                .saveNote();
        keep.waitForNoteToAppear(title);

        keep.findNotesTitle(title);
        keep.archiveNote();

        softAssert.assertTrue(keep.waitForNoteToDisappear(title),
                "Note should not be visible on the main notes list after archiving.");

        LeftSideModal leftSideModal = keep.tapMenuBurgerButton().openBurgerButtonModal();
        ArchivePage archivePage = leftSideModal.tapArchiveButton().tapGotItButton();
        archivePage.findArchivedNoteByTitle(title);

        softAssert.assertAll();
    }
}