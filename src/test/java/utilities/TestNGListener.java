package utilities;

import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TestNGListener implements ISuiteListener, TestNGListenerInterface {

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("Finishing");
    }

    @Override
    public void onStart(ISuite suite) {
        System.out.println("Starting");
    }

    /**
     * @param suite
     */
    @Override
    public void onTestStart(ISuite suite) {
        System.out.println("Test named : " + suite.getName() + "has began its execution");
    }

    /**
     * @param suite
     */
    @Override
    public void onTestSuccess(ISuite suite) {
        System.out.println("Test named : " + suite.getName() + "has successfully finished its execution");
    }

    /**
     * @param suite
     */
    @Override
    public void onTestFailure(ISuite suite) {
        System.out.println("Test named : " + suite.getName() + "has failed and produced errors in its execution");
    }

    /**
     * @param suite
     */
    @Override
    public void onTestSkipped(ISuite suite) {
        System.out.println("Test named : " + suite.getName() + "has been skipped for this execution");
    }

    /**
     * @param arg0
     */
}
