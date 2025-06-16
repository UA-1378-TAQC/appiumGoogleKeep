package com.googleKeep.ui;

import com.google.googlekeep.pages.MainPage;
import com.google.googlekeep.pages.ListNotePage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class CreateListNoteTest extends BaseTestRunner {

    private static final String CHECKLIST_TITLE = "Shopping List";
    private static final String[] CHECKLIST_ITEMS = {"Milk", "Bread", "Eggs"};

    @Test
    public void createAndVerifyListNoteTest() {

        SoftAssert softAssert = new SoftAssert();
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
        int itemCount = listNotePage.getItemCount();
        softAssert.assertEquals(itemCount, CHECKLIST_ITEMS.length,
                "Should have correct number of items created");

        for (int i = 0; i < CHECKLIST_ITEMS.length; i++) {
            String itemText = listNotePage.getItemText(i);
            softAssert.assertTrue(itemText.contains(CHECKLIST_ITEMS[i]),
                    "Item " + i + " should contain expected text: " + CHECKLIST_ITEMS[i]);
        }

        listNotePage.saveNote();

        boolean noteAppeared = mainPage.waitForNoteToAppear(CHECKLIST_TITLE, 10);
        softAssert.assertTrue(noteAppeared,
                "Note should appear in main list after saving");

        boolean noteDisplayed = mainPage.isNoteDisplayed(CHECKLIST_TITLE);
        softAssert.assertTrue(noteDisplayed,
                "Note should be visible in main list");

        mainPage.findNotesTitle(CHECKLIST_TITLE);

        int reopenedItemCount = listNotePage.getItemCount();
        softAssert.assertEquals(reopenedItemCount, CHECKLIST_ITEMS.length,
                "All items should be preserved after reopening");

        for (int i = 0; i < CHECKLIST_ITEMS.length; i++) {
            String reopenedText = listNotePage.getItemText(i);
            softAssert.assertTrue(reopenedText.contains(CHECKLIST_ITEMS[i]),
                    "Item " + i + " content should be preserved: " + CHECKLIST_ITEMS[i]);
        }

    }

}
