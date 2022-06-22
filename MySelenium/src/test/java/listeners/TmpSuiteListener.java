package listeners;

import helpers.PropertyHelper;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TmpSuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        String env = suite.getParameter("env");
        PropertyHelper.initProperty(String.format("src\\test\\resources\\config.%s.properties", env));
    }
}
