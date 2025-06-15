package com.googleKeep.ui;
import com.google.googlekeep.pages.KeepNotePage;
import org.testng.annotations.*;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;

public class BaseTest extends BaseTestRunner {

    @Test
    public void firstTest() {
        Assert.assertNotNull(driver, "Driver should be initialized");
    }

    @Test
    public void testLoginSuccess() {
        KeepNotePage loginPage = new KeepNotePage(driver);
        loginPage.skipWelcome();
        loginPage.tapAddButton();

    }
}
