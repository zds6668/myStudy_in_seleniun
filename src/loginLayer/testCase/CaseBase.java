package loginLayer.testCase;

import loginLayer.Base.DriverBase;

public class CaseBase {
	public DriverBase InitDriver(String browser) {
		return new DriverBase(browser);
	}
}
