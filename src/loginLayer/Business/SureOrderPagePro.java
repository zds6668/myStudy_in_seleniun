package loginLayer.Business;

import loginLayer.Base.DriverBase;
import loginLayer.Handle.SureOrderHandle;

public class SureOrderPagePro {
	public SureOrderHandle sureOrderHandle;
	public DriverBase driver;
	public SureOrderPagePro(DriverBase driver) {
		this.driver = driver;
		sureOrderHandle = new SureOrderHandle(driver);
	}
	
	/*
	 * 确认订单按钮
	 */
	public void sureOrder() {
		sureOrderHandle.clickSubOrderElement();
	}
}
