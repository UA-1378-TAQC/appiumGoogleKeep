package com.googleKeep.ui;

import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByKeywordsTest extends BaseTestRunner {

    String LABEL_NAME = "Label1";
    String NOTE_NAME = "Test1";

    @Test
    void searchByKeywordTest() {
        keep.tapMenuBurgerButton().openBurgerButtonModal()//questionable
                .tapCreateNewLabelButton().createLabel(LABEL_NAME).exit();

        keep.tapMenuBurgerButton().openBurgerButtonModal().tapLabelButton(LABEL_NAME).tapAddButtonOnMain().createTextNote().enterTitle(NOTE_NAME).saveNote();

        var searchMenu = keep.tapMenuBurgerButton().openBurgerButtonModal().tapAllNotesButton().tapSearchLabel().enterText(LABEL_NAME);

        var names = searchMenu.getFoundedNames();
        Assert.assertTrue(names.contains(NOTE_NAME));

        searchMenu.exit();
    }
}
