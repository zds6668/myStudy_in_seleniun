package loginLayer.Page;

import org.openqa.selenium.WebElement;

import loginLayer.Base.DriverBase;
import loginLayer.Util.getByLocator;

public class SureOrderPage extends BasePage{
	public SureOrderPage(DriverBase driver) {
		super(driver);
	}
	
	/*
	 * 获取提交订单按钮
	 */
	public WebElement getSubOrderElement() {
		return element(getByLocator.getLocator("sureOrder"));
	}
}
