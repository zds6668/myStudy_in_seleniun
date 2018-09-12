package loginLayer.Business;

import loginLayer.Base.DriverBase;
import loginLayer.Handle.OrderPayPageHandle;

public class OrderPayPagePro {
	public DriverBase driver;
	public OrderPayPageHandle orderPayPageHandle;
	public OrderPayPagePro(DriverBase driver) {
		this.driver = driver;
		orderPayPageHandle = new OrderPayPageHandle(driver);
	}
	/*
	 * 根据课程订单判断跳转到支付页面
	 */
	public void orderPayPro() {
		String orderName = orderPayPageHandle.getOrderName();
		String courseName = orderPayPageHandle.getOrderCourseName();
		if (orderName!=null && courseName!=null) {
			orderPayPageHandle.clickAlipay();
			orderPayPageHandle.clickPayElement();
		}
	}
}
