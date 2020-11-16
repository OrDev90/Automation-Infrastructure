package runner_utils;

import driver_utils.DriverFactory;
import driver_utils.ExtendedWebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.homepage.HomePage;
import reporter.ExtentReporter;
import java.io.IOException;

public abstract class TestBase extends TestBaseUtils {

    protected ExtentReporter extentReporter;
    protected ExtendedWebDriver driverManager;
    protected CustomAssert customAssert;

    protected HomePage homePage;

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("****************** Suite Started ******************");
        extentReporter = ExtentReporter.getInstance();
        WebsiteConfiguration.initConfiguration();
    }

    @AfterSuite
    public void afterSuite(ITestContext context) {
        System.out.println("****************** Suite Finished ******************");
        extentReporter.getExtentReports().flush();
        killDrivers(context.getCurrentXmlTest().getParameter("browser"));
    }

    @BeforeMethod
    public void beforeMethod(ITestContext context) {
        this.extentReporter.createTest(context.getAllTestMethods()[extentReporter.getExtentTestList().size()].getMethodName(),
                context.getAllTestMethods()[extentReporter.getExtentTestList().size()].getDescription());
        System.out.println("****************** Method Started ******************");
        String browser = context.getCurrentXmlTest().getParameter("browser");
        boolean isHeadless = Boolean.parseBoolean(context.getCurrentXmlTest().getParameter("headless"));
        startBrowser(browser, isHeadless);
        this.customAssert = new CustomAssert(this.driverManager, this.extentReporter);
        NavigateToBaseUrl(getTestDriverManager());
        initAllPages();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("****************** Method Finished ******************");
        this.driverManager.quitDriver();
    }

    private void initAllPages() {
        this.homePage = new HomePage(this.customAssert);
    }

    private ExtendedWebDriver getTestDriverManager() {
        return this.driverManager;
    }

    private void startBrowser(String browser, boolean isHeadless) {
        this.driverManager = DriverFactory.getDriverManager(browser, isHeadless);
        this.driverManager.initDriver(browser);
        RemoteWebDriver remoteWebDriver = (RemoteWebDriver) this.driverManager.getDriver();
        this.driverManager.setBrowserName(remoteWebDriver.getCapabilities().getBrowserName());
        this.driverManager.getDriver().manage().window().maximize();
    }

    private void killDrivers(String browser) {
        try {
            if(browser.contentEquals("chrome"))
                Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
            else
                Runtime.getRuntime().exec("taskkill /F /IM geckodriver.exe");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
