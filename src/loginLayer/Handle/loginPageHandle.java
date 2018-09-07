package loginLayer.Handle;


import loginLayer.Base.DriverBase;
import loginLayer.Page.loginPage;

public class loginPageHandle {
	public DriverBase driver;
	public loginPage lP;
	public loginPageHandle(DriverBase driver) {
		this.driver = driver;
		lP = new loginPage(driver);
	}
	
	/*
	 * 输入用户名
	 */
	public void sendName(String username) {
		lP.sendkeys(lP.getUserElement(), username);
	}
	
	/*
	 * 输入密码
	 */
	public void sendPassword(String password) {
		lP.sendkeys(lP.getPasswordElement(), password);
	}
	
	/*
	 * 点击登录
	 */
	public void clickLoginButton() {
		lP.click(lP.getLoginButton());
	}
	
	/*
	 * 点击自动登录
	 */
	public void clickAutoLogin() {
		lP.click(lP.getAotoLogin());
	}
}
