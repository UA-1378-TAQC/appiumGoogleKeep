package com.googleKeep.ui.testrunners;

import com.google.googlekeep.pages.MainPage;
import com.googleKeep.utils.TestValueProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.qameta.allure.Step;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;


public class BaseTestRunner {
    protected AppiumDriver driver;
    protected MainPage keep;
    protected TestValueProvider testValueProvider = new TestValueProvider();

    public void connectToAndroid() {
        System.out.println("Connecting to Android device...");

        try {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName(testValueProvider.getPlatformName())
                    .setPlatformVersion(testValueProvider.getPlatformVersion())
                    .setDeviceName(testValueProvider.getDeviceName())
                    .setAutomationName(testValueProvider.getAutomationName())
                    .setAppPackage(testValueProvider.getAppPackage())
                    .setAppActivity(testValueProvider.getAppActivity());

            String appiumServerURL = testValueProvider.getAppiumServerURL();
            System.out.println("Appium server URL: " + appiumServerURL);
            URL url = new URL(appiumServerURL);
            driver = new AndroidDriver(url, options);
            driver.manage().timeouts().implicitlyWait(testValueProvider.getImplicitlyWait());
            System.out.println("✅ Successfully connected to Android device");

        } catch (MalformedURLException e) {
            System.err.println("❌ Invalid URL: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("❌ Failed to connect to Android: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Step("init AppiumDriver")
    public void initDriver(String platform) {
        switch (platform.toLowerCase()) {
            case "android":
                connectToAndroid();
                break;
            default:
                System.err.println("❌ Unsupported platform: " + platform);
        }
    }

    @BeforeSuite
    public void beforeSuite() {
        initDriver("android");
    }

    @AfterSuite
    public void afterSuite() {
        if (driver != null) {
            System.out.println("Disconnecting from device...");
            try {
                driver.quit();
                System.out.println("✅ Successfully disconnected");
            } catch (Exception e) {
                System.err.println("❌ Error during disconnect: " + e.getMessage());
            } finally {
                driver = null;
            }
        } else {
            System.out.println("⚠️ No active connection to disconnect");
        }
    }

    @BeforeMethod
    public void commonSetup() {
        keep = new MainPage(driver);
        keep.skipWelcome()
                .tapCancelButton();
    }
}
