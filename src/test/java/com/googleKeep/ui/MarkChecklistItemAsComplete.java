package com.googleKeep.ui;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.googlekeep.pages.ListNotePage;
import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;


public class MarkChecklistItemAsComplete extends BaseTestRunner{
    @Test
    public void MarkChecklistComplete(){
        MainPage mainPage = new MainPage(driver);
        SoftAssert softAssert = new SoftAssert();
        
        String dataOne = "Test1";
        String dataTwo = "Test2";
        String dataThree = "Test3";
        String title = "TC7";


        ListNotePage listNotePage = mainPage.tapAddButtonOnMain()
                .createListNote();

        listNotePage.enterTitle(title);

        listNotePage.enterListItem(dataOne);
        listNotePage.addListItem();

        listNotePage.enterListItem(dataTwo);
        listNotePage.addListItem();
        
        listNotePage.enterListItem(dataThree);

        int itemCount = listNotePage.getItemCount();
        softAssert.assertEquals(itemCount, 3,
                "Should have correct number of items created");

        listNotePage.markItemInCheckList();

        softAssert.assertEquals(listNotePage.getMarkedData(),dataOne);

        listNotePage.saveNote();

        softAssert.assertAll();
    }
}
