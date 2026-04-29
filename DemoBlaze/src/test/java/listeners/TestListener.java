package listeners;

import base.BaseTest;
import com.aventstack.extentreports.*;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getInstance();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed ✅");
    }

    @Override
    public void onTestFailure(ITestResult result) {

        WebDriver driver = BaseTest.getDriver(); // ✅ FIXED

        String path = ScreenshotUtil.capture(driver, result.getMethod().getMethodName());

        test.get().fail(result.getThrowable());

        if (path != null) {
            test.get().addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}