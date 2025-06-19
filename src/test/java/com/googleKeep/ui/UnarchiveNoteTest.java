package com.googleKeep.ui;

import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UnarchiveNoteTest extends BaseTestRunner {

    @BeforeMethod
    public void createAndArchiveNote() {
        MainPage keep = new MainPage(driver);
        String title = "Archive Note Title";
        String body = "sample text";
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

    }


}
