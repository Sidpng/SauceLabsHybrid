package utilities;

import org.testng.ISuite;
import org.testng.ITestResult;

public interface TestNGListenerInterface {
    void onFinish(ISuite suite);

    void onStart(ISuite suite);

    void onTestStart(ISuite suite);

    void onTestSuccess(ISuite suite);

    void onTestFailure(ISuite suite);

    void onTestSkipped(ISuite suite);

}
