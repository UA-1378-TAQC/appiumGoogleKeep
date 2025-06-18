package com.googleKeep.ui;

import com.google.googlekeep.pages.EditLabelsPage;
import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewLabelTest extends BaseTestRunner {
    @Test
    public void createTextNoteTest() {
        String LABEL_TEXT = "NewTestLabel!@#_+-";
        MainPage keep = new MainPage(driver);
        EditLabelsPage labelsPage =keep.tapMenuBurgerButton()
                .openBurgerButtonModal()
                .tapCreateNewLabelButton()
                .enterNewLabelName(LABEL_TEXT)
                .clickSubmit();

        boolean isLabelFound = labelsPage.waitForLabelToAppear(LABEL_TEXT);

        Assert.assertTrue(isLabelFound, "Label with title not found!");
    }

}
