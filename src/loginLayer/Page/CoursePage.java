package loginLayer.Page;

import org.openqa.selenium.WebElement;

import loginLayer.Base.DriverBase;
import loginLayer.Util.getByLocator;

public class CoursePage extends BasePage{
	public CoursePage(DriverBase driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	}
	
	/*
	 * 获取立即购买按钮element
	 */
	public WebElement getBuytriggerElement() {
		return element(getByLocator.getLocator("buynow"));
	}
	
	/*
	 * 获取添加购物车element
	 */
	public WebElement getAddCartElement() {
		return element(getByLocator.getLocator("addCart"));
	}
	
	/*
	 * 获取右上角购物车element
	 */
	public WebElement getShopCartElement() {
		return element(getByLocator.getLocator("shopCart"));
	}
	
	/*
	 * 获取购物车数量element
	 */
	public WebElement getShopCartNumElement() {
		return element(getByLocator.getLocator("cartNum"));
	}
	
	/*
	 * 获取课程详情的课程名称
	 */
	public WebElement getCourseNameElement() {
		return nodeElement(getByLocator.getLocator("courseInfo"), getByLocator.getLocator("courseInfoText"));
	}
	
}
