package loginLayer.Page;


import org.openqa.selenium.WebElement;

import loginLayer.Base.DriverBase;
import loginLayer.Util.getByLocator;

public class loginPage extends BasePage{
	public loginPage(DriverBase driver){
		super(driver);
	}
	
	/*
	 * 获取用户名输入框
	 */
	public WebElement getUserElement() {
		return element(getByLocator.getLocator("name"));
	}
	
	/*
	 * 获取密码输入框
	 */
	public WebElement getPasswordElement() {
		return element(getByLocator.getLocator("userpass"));
	}
	
	/*
	 * 获取登录按钮
	 */
	public WebElement getLoginButton() {
		return element(getByLocator.getLocator("loginButton"));
	}
	
	/*
	 * 获取自动登录
	 */
	public WebElement getAotoLogin() {
		return element(getByLocator.getLocator("Autologin"));
	}
}
