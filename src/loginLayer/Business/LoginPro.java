package loginLayer.Business;

import com.google.common.reflect.ClassPath;

import loginLayer.Base.DriverBase;
import loginLayer.Handle.loginPageHandle;

public class LoginPro {
	public loginPageHandle lph;
	public LoginPro(DriverBase driver) {
		// TODO Auto-generated constructor stub
		lph = new loginPageHandle(driver);
	}
	public void login(String username, String password) {
		if (lph.lP.isDispaly(lph.lP.getUserElement())) {
			lph.sendName(username);
			lph.sendPassword(password);
			lph.clickAutoLogin();
			lph.clickLoginButton();
		}else {
			System.out.println("登录页面不存在");
		}
	}
}
