package com.googleKeep.ui.testrunners;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Duration;

import com.coffeecart.utils.TestValueProvider;


public class BaseTestRunner {

//    protected static LocalStorageJS localStorageJS;
//    protected static WebDriver driver;
//    protected static TestValueProvider testValueProvider;
//
//    @BeforeSuite
//    public void beforeSuite() {
//        WebDriverManager.chromedriver().setup();
//        testValueProvider = new TestValueProvider();
//        initDriver();
//    }
//
//    @Step("init ChromeDriver")
//    public void initDriver() {
//        ChromeOptions options = new ChromeOptions();
//
//        String chromeOptionsArg = System.getProperty("chrome.options", "");
//        if (!chromeOptionsArg.isEmpty()) {
//            for (String option : chromeOptionsArg.split(",")) {
//                options.addArguments(option);
//            }
//        }
//
//        String userDataDir = System.getProperty("user.data.dir");
//        if (userDataDir != null && !userDataDir.isEmpty()) {
//            options.addArguments("--user-data-dir=" + userDataDir);
//        }
//
//        String lang = System.getProperty("chrome.options", "--lang=en");
//        if (lang != null && !lang.isEmpty()) {
//            options.addArguments(lang);
//        }
//
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(testValueProvider.getImplicitlyWait()));
//
//        localStorageJS = new LocalStorageJS(driver);
//    }
//
//
//
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
//    @AfterSuite
//    public void afterSuite() {
//        if (driver != null) {
//            driver.quit();
//        }
//        driver = null;
//    }
//
//    @Step("Clear Browser Memory Cookies and LocalStorage.")
//    public void clearBrowserMemory() {
//        driver.manage().deleteAllCookies();
//        localStorageJS.clearLocalStorage();
//        driver.navigate().refresh();
//    }
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
