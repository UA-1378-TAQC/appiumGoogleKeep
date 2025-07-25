package com.googleKeep.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.googlekeep.components.HeaderEditorToolbarComponent;
import com.google.googlekeep.modal.LeftSideModal;
import com.google.googlekeep.pages.ArchivePage;
import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;

public class UnarchiveNoteTest extends BaseTestRunner {
    String title = "Archive Note Title";
    String body = "test";
    HeaderEditorToolbarComponent headerEditorToolbarComponent;
    LeftSideModal leftSideModal;

    @BeforeMethod
    public void createAndArchiveNote() {
        MainPage keep = new MainPage(driver);

        keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(title)
                .enterBody(body)
                .saveNote();
        keep.waitForNoteToAppear(title);
        keep.findNotesTitle(title);
        keep.archiveNote();
    }

    @Test
    public void unarchiveNote() {
        SoftAssert softAssert = new SoftAssert();
        ArchivePage archivePage = keep
                .tapMenuBurgerButton()
                .openBurgerButtonModal()
                .tapArchiveButton()
                .tapGotItButton();
        archivePage.findArchivedNoteByTitle(title);

        archivePage.unarchiveNote().tapBachOnArchive();
        leftSideModal = archivePage.tapArchivedBurgerButton();
        leftSideModal.tapNotesButton();
        keep.findNotesTitle(title);

        softAssert.assertTrue(keep.isNoteDisplayed(title),
                "Unarchived note should be visible in the main notes list");

        softAssert.assertTrue(keep.isNoteBodyDisplayed(body),
                "Unarchived note body should be visible in the main notes list");

        softAssert.assertAll();
    }
}
