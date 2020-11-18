package reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ExtentReporter {

    private static ExtentReporter extentReporter = null;

    @Getter
    private final List<ExtentTest> extentTestList = new ArrayList<>();

    @Getter
    private final ExtentReports extentReports;

    private ExtentReporter(String browser) {
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter("./reports/" +
                ReporterUtils.generateReportName() + ".html");
        extentSparkReporter.config().setEncoding("utf-8");
        extentSparkReporter.config().setDocumentTitle("Automation Report");
        extentSparkReporter.config().setReportName("Automation Test Results");
        extentSparkReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.setSystemInfo("Browser", StringUtils.capitalize(browser));
        extentReports.attachReporter(extentSparkReporter);
    }

    public static ExtentReporter getInstance(String browser) {
        if(extentReporter == null)
            extentReporter = new ExtentReporter(browser);
        return extentReporter;
    }

    public void createTest(String testName, String description) {
        this.extentTestList.add(this.extentReports.createTest(testName, description));
    }

    public void log(Status status, String message, Media... media) {
        if(status.equals(Status.FAIL))
            this.extentTestList.get(this.extentTestList.size() - 1).log(status, message, media[0]);
        else
            this.extentTestList.get(this.extentTestList.size() - 1).log(status, message);
    }
}
