package com.googleKeep.ui;

import com.google.googlekeep.pages.EditLabelsPage;
import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateNewLabelTest extends BaseTestRunner {
    @Test
    public void createTextNoteTest() {
        MainPage keep = new MainPage(driver);
        EditLabelsPage labelsPage =keep.tapMenuBurgerButton()
                .openBurgerButtonModal()
                .tapCreateNewLabelButton()
                .enterNewLabelName("NewTestLabel")
                .clickSubmit();

        boolean isLabelFound = labelsPage.getLabelNames().contains("NewTestLabel");

        Assert.assertTrue(isLabelFound, "Label with title not found!");
    }

}
