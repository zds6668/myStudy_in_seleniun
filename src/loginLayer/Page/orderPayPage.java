package loginLayer.Page;

import org.openqa.selenium.WebElement;

import loginLayer.Base.DriverBase;
import loginLayer.Util.getByLocator;

public class orderPayPage extends BasePage{
	public orderPayPage(DriverBase driver) {
		super(driver);
	}
	
	/*
	 * 获取订单号element
	 */
	public WebElement getOrderNumElement() {
		return element(getByLocator.getLocator("order"));
	}
	
	/*
	 * 返回课程名称element
	 */
	public WebElement getOrderCourseNameElement() {
		return nodeElement(getByLocator.getLocator("orderCourse"),getByLocator.getLocator("orderCourseNode"));
	}
	
	/*
	 * 返回支付包element
	 */
	public WebElement getAliPayElement() {
		return element(getByLocator.getLocator("alipay"));
	}
	
	/*
	 * 点击立即支付element
	 */
	public WebElement getOrderPayElement() {
		return element(getByLocator.getLocator("orderpay"));
	}
}
