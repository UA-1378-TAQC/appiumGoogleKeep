package com.googleKeep.ui;
import com.google.googlekeep.pages.MainPage;
import org.testng.annotations.*;
import com.googleKeep.ui.testrunners.BaseTestRunner;
import org.testng.Assert;

public class BaseTest extends BaseTestRunner {

    @Test
    public void firstTest() {
        //checks weather this project can connect to your device
        Assert.assertNotNull(driver, "Driver should be initialized");
    }
}
