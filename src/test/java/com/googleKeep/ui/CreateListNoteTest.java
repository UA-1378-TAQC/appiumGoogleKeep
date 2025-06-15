package com.googleKeep.ui;

import com.google.googlekeep.pages.KeepNotePage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.annotations.Test;

public class CreateListNoteTest extends BaseTestRunner {
    private static final String CHECKLIST_TITLE = "Shopping List";
    private static final String[] CHECKLIST_ITEMS = {"Milk", "Bread", "Eggs"};

    @Test
    public void createAndVerifyListNoteTest() {
        KeepNotePage keep = new KeepNotePage(driver);

        keep.skipWelcome()
                .tapCancelButton()
                .tapAddButton()
                .createListNote();
    }

}
