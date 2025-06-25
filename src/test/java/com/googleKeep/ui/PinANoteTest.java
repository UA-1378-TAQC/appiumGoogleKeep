package com.googleKeep.ui;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.googlekeep.pages.ListNotePage;
import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;

public class PinANoteTest extends BaseTestRunner{
    @Test
    public void PinANote()
    {
        MainPage mainPage = new MainPage(driver);
        SoftAssert softAssert = new SoftAssert();
        
        String dataOne = "Test1";
        String title = "TC16";
        String state = "Pinned";

        mainPage.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(title)
                .enterBody(dataOne)
                .PinANote()
                .saveNote();

        softAssert.assertEquals(mainPage.IsPinned(),state);

        softAssert.assertAll();

    }
}
