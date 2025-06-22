package com.googleKeep.ui;

import com.google.googlekeep.pages.CheckLabelsPage;
import com.google.googlekeep.pages.EditLabelsPage;
import com.google.googlekeep.pages.MainPage;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Thread.sleep;

public class AddingLabelsTest extends BaseTestRunner {

    private MainPage mainPage;

    private final String[] labels = {"Label1", "Label2", "Label3"};
    private final String[] noteTitles = {"Note 1", "Note 2", "Note 3"};

    @BeforeMethod
    public void setUpTestData() {
        mainPage = new MainPage(driver);

        for (String label : labels) {
            mainPage.tapMenuBurgerButton()
                    .openBurgerButtonModal()
                    .tapCreateNewLabelButton()
                    .enterNewLabelName(label)
                    .clickSubmit()
                    .saveNote();
        }

        mainPage.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(noteTitles[0])
                .saveNote();

        mainPage.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(noteTitles[1])
                .saveNote();

        mainPage.tapAddButtonOnMain()
                .createTextNote()
                .enterTitle(noteTitles[2])
                .saveNote();
    }

    @Test
    public void testAddAndVerifyLabelsOnNotes() {
        SoftAssert softAssert = new SoftAssert();

        for (int i = 0; i < noteTitles.length; i++) {
            mainPage.findNotesTitle(noteTitles[i]);

            mainPage.getFooterEditorToolbarComponent()
                    .openActionMenu()
                    .tapLabelsOption();

            for (int j = 0; j <= i; j++) {
                new CheckLabelsPage(driver).selectLabel(labels[j]);
            }

            mainPage.tapBackArrow();
            mainPage.tapBackArrow();
        }

        for (int i = 0; i < noteTitles.length; i++) {
            for (int j = 0; j <= i; j++) {
                softAssert.assertTrue(
                        mainPage.verifyLabelPresentOnNote(noteTitles[i], labels[j]),
                        "❌ Label '" + labels[j] + "' not found on note '" + noteTitles[i] + "'"
                );
            }
        }

        softAssert.assertAll();
    }

    @AfterMethod
    public void cleanUpTestData() throws InterruptedException {
        for (String title : noteTitles) {
            mainPage.deleteNoteByTitle(title);
        }

        EditLabelsPage editLabelsPage = mainPage.tapMenuBurgerButton()
                .openBurgerButtonModal()
                .tapCreateNewLabelButton();

        List<String> labelList = new ArrayList<>(Arrays.asList(labels));

        for (String label : labelList) {
            if (editLabelsPage.waitForLabelToAppear(label)) {
                editLabelsPage.deleteLabel(label);
                sleep(1000);
            }
        }

        mainPage.tapMenuBurgerButton().openBurgerButtonModal();
    }
}
