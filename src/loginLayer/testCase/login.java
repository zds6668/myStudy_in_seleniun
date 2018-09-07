package loginLayer.testCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import loginLayer.Base.DriverBase;
import loginLayer.Business.LoginPro;


public class login extends CaseBase{
	public DriverBase driver;
	public LoginPro loginPro;
	static Logger logger = Logger.getLogger(login.class);
	public login() {
		this.driver = InitDriver("chrome");
		loginPro = new LoginPro(driver);
	}
	@Test
	public void getLogHome() {
		driver.get("https://www.imooc.com");
		driver.findelement(By.id("js-signin-btn")).click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test(dependsOnMethods= {"getLogHome"})
	public void testLogin() {
		logger.debug("我第一次用log4j");
		loginPro.login("18291857993", "19970505");
	}
}
