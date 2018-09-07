package testLogin;

import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestngListenerScreenShot extends TestListenerAdapter {

	@Override
	public void onTestSuccess(ITestResult tr) {
		super.onTestSuccess(tr);
	}
	
	@Override
	public void onTestFailure(ITestResult tr) {
		super.onTestFailure(tr);
		baseDriver baseDriver = (baseDriver)tr.getInstance();
		baseDriver.takeScreenShot();
	}
}
