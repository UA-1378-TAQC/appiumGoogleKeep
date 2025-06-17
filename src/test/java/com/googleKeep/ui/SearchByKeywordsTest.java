package com.googleKeep.ui;

import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchByKeywordsTest extends BaseTestRunner {

    @Test
    void SearchByKeywordTest(){
        keep.tapMenuBurgerButton()
                .openBurgerButtonModal()//questionable
                .tapCreateNewLabelButton()
                .createLabel("Label1").exit();

        keep.tapMenuBurgerButton().openBurgerButtonModal().tapLabelButton("Label1").tapAddButtonOnMain().createTextNote().enterTitle("Test1").saveNote();

        keep.tapMenuBurgerButton().openBurgerButtonModal().tapAllNotesButton().tapSearchLabel();

        keep.tapMenuBurgerButton()
                .openBurgerButtonModal()//questionable
                .tapCreateNewLabelButton()
                .deleteLabel("Label1").exit();
    }
}
