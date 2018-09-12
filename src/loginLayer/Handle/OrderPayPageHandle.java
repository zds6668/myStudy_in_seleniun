package loginLayer.Handle;

import loginLayer.Base.DriverBase;
import loginLayer.Page.orderPayPage;

public class OrderPayPageHandle {
	public DriverBase driver;
	public orderPayPage orderPayPage;
	public OrderPayPageHandle(DriverBase driver) {
		this.driver = driver;
		orderPayPage = new orderPayPage(driver);
	}
	/*
	 * 获取订单文字
	 */
	public String getOrderName() {
		return orderPayPage.getText(orderPayPage.getOrderNumElement());
	}
	/*
	 * 获取课程名称
	 */
	public String getOrderCourseName() {
		return orderPayPage.getText(orderPayPage.getOrderCourseNameElement());
	}
	/*
	 * 点击支付包支付
	 */
	public void clickAlipay() {
		orderPayPage.click(orderPayPage.getAliPayElement());
	}
	/*
	 * 点击立即支付
	 */
	public void clickPayElement() {
		orderPayPage.click(orderPayPage.getOrderPayElement());
	}
}
