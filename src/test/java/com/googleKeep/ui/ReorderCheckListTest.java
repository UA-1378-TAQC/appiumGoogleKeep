package com.googleKeep.ui;

import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ReorderCheckListTest extends BaseTestRunner {

    String ITEM1_NAME = "test1";
    String ITEM2_NAME = "test2";

    @Test
    void reorderCheckListTest(){

        var listNote = keep.tapAddButtonOnMain().createListNote();

        listNote.enterListItem(ITEM1_NAME).addListItem().enterListItem(ITEM2_NAME).reorderElements(0,1);

        Assert.assertEquals(listNote.getItemText(0),ITEM2_NAME);
        Assert.assertEquals(listNote.getItemText(1),ITEM1_NAME);

    }
}
