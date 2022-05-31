package listeners;

import helpers.PropertyHelper;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.annotations.AfterClass;

public class TmpSuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        PropertyHelper.initProperty("config.prod.properties");
    }
}
