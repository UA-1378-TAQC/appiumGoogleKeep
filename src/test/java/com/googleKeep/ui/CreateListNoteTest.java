package com.googleKeep.ui;

import com.google.googlekeep.pages.MainPage;
import com.google.googlekeep.pages.ListNotePage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateListNoteTest extends BaseTestRunner {

        private static final String CHECKLIST_TITLE = "Shopping List";
        private static final String[] CHECKLIST_ITEMS = {"Milk", "Bread", "Eggs"};

        @Test
        public void createAndVerifyListNoteTest() {
            MainPage mainPage = new MainPage(driver);

            ListNotePage listNotePage = mainPage.tapAddButtonOnMain()
                    .createListNote();

            listNotePage.enterTitle(CHECKLIST_TITLE);

            for (int i = 0; i < CHECKLIST_ITEMS.length; i++) {
                listNotePage.enterListItem(CHECKLIST_ITEMS[i]);
                if (i < CHECKLIST_ITEMS.length - 1) {
                    listNotePage.addListItem();
                }
            }

            listNotePage.saveNote();

            Assert.assertTrue(mainPage.waitForNoteToAppear(CHECKLIST_TITLE, 5),
                    "Note should appear in the main list within 5 seconds");

            Assert.assertTrue(mainPage.isNoteDisplayed(CHECKLIST_TITLE),
                    "Note with title '" + CHECKLIST_TITLE + "' should be displayed in main list");

            mainPage.findNotesTitle(CHECKLIST_TITLE);


        }

}
