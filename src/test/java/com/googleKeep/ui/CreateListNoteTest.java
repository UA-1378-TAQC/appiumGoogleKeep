package com.googleKeep.ui;

import com.google.googlekeep.pages.KeepNotePage;
import com.google.googlekeep.pages.ListNotePage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateListNoteTest extends BaseTestRunner {
    private static final String CHECKLIST_TITLE = "Shopping List";
    private static final String[] CHECKLIST_ITEMS = {"Milk", "Bread", "Eggs"};

    @Test
    public void createAndVerifyListNoteTest() {
        KeepNotePage keep = new KeepNotePage(driver);
        ListNotePage list = new ListNotePage(driver);

        keep.tapAddButton()
                .createListNote()
                .enterTitle(CHECKLIST_TITLE);

        for (String item : CHECKLIST_ITEMS) {
            list.enterListItem(item);
            list.addListItem();
        }

        keep.saveNote();
        keep.waitForNoteToAppear(CHECKLIST_TITLE, 3);
        keep.findNotesTitle(CHECKLIST_TITLE);
        Assert.assertTrue(keep.isNoteDisplayed(CHECKLIST_TITLE), "Note with title not found!");
    }


}
