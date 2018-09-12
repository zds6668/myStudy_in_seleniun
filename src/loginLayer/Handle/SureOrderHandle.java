package loginLayer.Handle;

import loginLayer.Base.DriverBase;
import loginLayer.Page.SureOrderPage;

public class SureOrderHandle {
	public SureOrderPage sureOrderPage;
	public DriverBase driver;
	public SureOrderHandle(DriverBase driver) {
		this.driver = driver;
	}
	
	/*
	 * 点击确认订单按钮
	 */
	public void clickSubOrderElement() {
		sureOrderPage.click(sureOrderPage.getSubOrderElement());
	}
}
