package com.googleKeep.ui;

import com.google.googlekeep.pages.ArchivePage;
import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnarchiveNoteTest extends BaseTestRunner {
    String title = "Archive Note Title";
    String body = "sample text";

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
        ArchivePage archivePage = keep
                .tapMenuBurgerButton()
                .openBurgerButtonModal()
                .tapArchiveButton();
        archivePage.findArchivedNoteByTitle(title);

        archivePage.archiveNote();
    }


}
