package com.googleKeep.ui.testrunners;

import com.googleKeep.utils.TestValueProvider;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.time.Duration;


public class BaseTestRunner {
    protected AppiumDriver driver;
    protected TestValueProvider testValueProvider = new TestValueProvider();

    // Android Connection
    public void connectToAndroid() {
        System.out.println("Connecting to Android device...");

        try {
            DesiredCapabilities caps = new DesiredCapabilities();

            // Basic Android capabilities
            caps.setCapability("platformName", testValueProvider.getPlatformName());
            caps.setCapability("platformVersion", testValueProvider.getPlatformVersion());
            caps.setCapability("deviceName", testValueProvider.getDeviceName());
            caps.setCapability("automationName", testValueProvider.getAutomationName());

            // App package and activity (for native app)
            caps.setCapability("appPackage", testValueProvider.getAppPackage());
            caps.setCapability("appActivity", testValueProvider.getAppActivity());

            // Or use app path
            // caps.setCapability("app", "/path/to/your/app.apk");

            // Create driver
            System.out.println(testValueProvider.getAppiumServerURL());
            driver = new AndroidDriver(new URI(testValueProvider.getAppiumServerURL()).toURL(), caps);
            driver.manage().timeouts().implicitlyWait(testValueProvider.getImplicitlyWait());

            System.out.println("✅ Successfully connected to Android device");

        } catch (MalformedURLException e) {
            System.err.println("❌ Invalid URL: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Failed to connect to Android: " + e.getMessage());
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

//    @BeforeClass
//    public void beforeClass() {
//        if (driver == null) {
//            initDriver();
//        }
//
//        driver.get(testValueProvider.getBaseUIUrl());
//    }
//
//
//
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

//
//    @AfterClass()
//    public void afterClass(ITestContext context) {
//        takeScreenShot("PICTURE Test Name = " + context.getName());
//        if (driver != null) {
//            driver.quit();
//        }
//        driver = null;
//    }
//
//    @Attachment(value = "Image name = {0}", type = "image/png")
//    public byte[] takeScreenShot(String attachName) {
//        byte[] result = null;
//        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        try {
//            result = Files.readAllBytes(scrFile.toPath());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return result;
//    }

    
}
