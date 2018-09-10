package loginLayer.testCase;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
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
//		logger.debug("我第一次用log4j");
		loginPro.login("18291857993", "19970505");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * 获取课程信息4-8
	 */
	public String getCourseText(WebElement element) {
		return element.getText();
	}
	
	/*
	 * 下单流程4-8
	 */
	@Test(dependsOnMethods={"testLogin"})
	public void buyCourse() {
		driver.get("https://coding.imooc.com/class/228.html");
		String courseDetil = driver.findelement(By.className("path")).findElement(By.tagName("span")).getText();
		driver.findelement(By.id("buy-trigger")).click();
		driver.findelement(By.linkText("提交订单")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String orderText = driver.findelement(By.className("order")).getText();
		if(orderText != null) {
			String orderString = driver.findelement(By.className("item")).findElement(By.className("left")).findElement(By.tagName("dt")).getText();
			Assert.assertEquals(orderString, courseDetil,"我们不一样");
		}
	}
}
