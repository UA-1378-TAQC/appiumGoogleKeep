package com.googleKeep.ui;

import com.google.googlekeep.components.HeaderEditorToolbarComponent;
import com.google.googlekeep.components.HeaderMainToolbarComponent;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import com.google.googlekeep.components.footerEditorComponents.ActionComponent;
import com.google.googlekeep.modal.LeftSideModal;
import com.google.googlekeep.pages.MainPage;
import com.google.googlekeep.pages.EditLabelsPage;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class NotesAreFilteredByLabelTest extends BaseTestRunner {
    @Test
    public void createTextNoteTest() {
        MainPage keep = new MainPage(driver);
        EditLabelsPage label = new EditLabelsPage(driver);
        HeaderMainToolbarComponent headerMain = new HeaderMainToolbarComponent(driver);
        HeaderEditorToolbarComponent headerEditor = new HeaderEditorToolbarComponent(driver);
        LeftSideModal createLabel = new LeftSideModal(driver);
        ActionComponent actionComponent = new ActionComponent(driver);

        SoftAssert softAssert = new SoftAssert();

        String label1 = "Work";
        String label2 = "Personal";

        headerMain.openBurgerButtonModal();
        createLabel.tapCreateNewLabelButton();

        label.enterNewLabelName(label1)
                .clickSubmit()
                .enterNewLabelName(label2)
                .clickSubmit()
                .waitForLabelToAppear(label2);

        softAssert.assertTrue(label.isLabelPresent(label1), "Label 'Work' was not created");
        softAssert.assertTrue(label.isLabelPresent(label2), "Label 'Personal' was not created");

        headerEditor.tapBackButton();
        keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle("Work Task")
                .enterBody("Finish report");
        actionComponent
                .openActionsMenu()
                .tapLabelsOption()
                .selectLabel(label1)
                .saveNote();
        headerEditor.tapBackButton();

        keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle("Shopping")
                .enterBody("Buy groceries");
        actionComponent
                .openActionsMenu()
                .tapLabelsOption()
                .selectLabel(label2)
                .saveNote();
        headerEditor.tapBackButton();


        keep.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle("Team Meeting")
                .enterBody("Complete task");
        actionComponent
                .openActionsMenu()
                .tapLabelsOption()
                .selectLabel(label1)
                .saveNote();
        headerEditor.tapBackButton();

        keep.tapMenuBurgerButton()
                .openBurgerButtonModal()
                .selectLabelFromSidebar(label1);

        softAssert.assertTrue(keep.isNoteDisplayed("Work Task"), "Note 'Work Task' not visible");
        softAssert.assertTrue(keep.isNoteDisplayed("Team Meeting"), "Note 'Team Meeting' not visible");
        softAssert.assertFalse(keep.isNoteDisplayed("Shopping"), "Note 'Shopping' should not be visible under 'Work' label");


        keep.tapMenuBurgerButton()
                .openBurgerButtonModal()
                .selectLabelFromSidebar(label2);

        softAssert.assertTrue(keep.isNoteDisplayed("Shopping"), "Note 'Shopping' not visible under 'Personal'");
        softAssert.assertFalse(keep.isNoteDisplayed("Work Task"), "Note 'Work Task' should not be visible under 'Personal'");
        softAssert.assertFalse(keep.isNoteDisplayed("Team Meeting"), "Note 'Team Meeting' should not be visible under 'Personal'");

        softAssert.assertAll();

    }
}
