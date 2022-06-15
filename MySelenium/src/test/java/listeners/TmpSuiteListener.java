package listeners;

import helpers.PropertyHelper;
import org.testng.ISuite;
import org.testng.ISuiteListener;

public class TmpSuiteListener implements ISuiteListener {
    @Override
    public void onStart(ISuite suite) {
        String env =  suite.getParameter("env");
        PropertyHelper.initProperty("config."+env+".properties");
    }
}
