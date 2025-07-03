package ListenersLayer;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import UtilityLayer.ExtentReportsetup;

public class Reports implements ITestListener {


    private ExtentReports report;
    private ThreadLocal<ExtentTest> extenttest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
    	this.report = ExtentReportsetup.setup(context.getSuite().getName());
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = report.createTest(result.getMethod().getMethodName());
        extenttest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extenttest.get().log(Status.PASS, "Test Passed: " + result.getMethod().getMethodName());
        captureScreenshot(result);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extenttest.get().log(Status.FAIL, "Test Failed: " + result.getMethod().getMethodName());
        extenttest.get().log(Status.FAIL, result.getThrowable());
        captureScreenshot(result);
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        extenttest.get().log(Status.SKIP, "Test Skipped: " + result.getMethod().getMethodName());
        captureScreenshot(result);
    }

    @Override
    public void onFinish(ITestContext context) {
        if (report != null)
            report.flush();
    }

    private void captureScreenshot(ITestResult result) {
        
        String path = ExtentReportsetup.takescreenshot("Screenshot", result.getMethod().getMethodName());
        try {
            extenttest.get().addScreenCaptureFromPath(path);
        } catch (Exception e) {
            extenttest.get().warning("Screenshot could not be attached: " + e.getMessage());
        }
    }
}
