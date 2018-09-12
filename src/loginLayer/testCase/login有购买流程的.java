package loginLayer.testCase;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import loginLayer.Base.DriverBase;
import loginLayer.Business.CoursePagePro;
import loginLayer.Business.LoginPro;
import loginLayer.Business.OrderPayPagePro;
import loginLayer.Business.SureOrderPagePro;
import loginLayer.Page.CoursePage;
import loginLayer.Util.getByLocator;


public class login extends CaseBase{
	public DriverBase driver;
	public LoginPro loginPro;
	public CoursePagePro cpp;
	public SureOrderPagePro sopp;
	public OrderPayPagePro opp;
	static Logger logger = Logger.getLogger(login.class);
	public login() {
		this.driver = InitDriver("chrome");
		loginPro = new LoginPro(driver);
		cpp = new CoursePagePro(driver);
		sopp = new SureOrderPagePro(driver);
		opp = new OrderPayPagePro(driver);
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
	 * 添加购物车4-13
	 */
	@Test(dependsOnMethods= {"testLogin"})
	public void TestAddCart() {
		driver.get("https://coding.imooc.com/class/195.html?");
		cpp.buyNow();
	}
	/*
	 * 提交订单
	 */
	@Test(dependsOnMethods= {"TestAddCart"})
	public void TestSureOrder() {
		sopp.sureOrder();
	}
	
	/*
	 * 跳转页面
	 */
	@Test(dependsOnMethods= {"TestSureOrder"})
	public void TestGoPay() {
		opp.orderPayPro();
	}
	

	
	/*
	 * 下单流程
	 */
//	@Test(dependsOnMethods={"testLogin"})
	public void downOrder(){
		driver.get("http://coding.imooc.com/class/74.html");
		String currentText = this.buyCourseNow();
		System.out.println("当前的课程信息"+currentText);
		this.sureOrder();
		this.getOrder();
		String orderCourseText = this.getOrderCourse();
		System.out.println("支付页面的课程信息"+orderCourseText);
		if(currentText.equals(orderCourseText)){
			System.out.println("下单成功");
		}
	}

	/*
	 * 获取课程信息4-8
	 */
	public String getCourseText(WebElement element) {
		return element.getText();
	}
	
	/*
	 * 获取element
	 */
	public WebElement getElement(By by) {
		return driver.findelement(by);
	}
	
	/*
	 * 通过父节点获取子节点
	 */
	public WebElement getElement(WebElement element, By by) {
		return element.findElement(by);
	}
	
	/*
	 * 立即购买，然后返回课程信息
	 */
	public String buyCourseNow() {
		WebElement element = this.getElement(getByLocator.getLocator("courseInfo"));
		WebElement elementNode = this.getElement(element, getByLocator.getLocator("courseInfoText"));
		String currentText = this.getCourseText(elementNode);
		this.getElement(getByLocator.getLocator("buynow")).click();
		return currentText;
	}
	
	/*
	 * 点击确定订单
	 */
	public void sureOrder() {
		this.getElement(getByLocator.getLocator("sureOrder")).click();		
	}
	
	/*
	 * 获取订单号
	 */
	public String getOrder() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String orderText = this.getCourseText(this.getElement(getByLocator.getLocator("order")));
		return orderText;
	}
	
	/*
	 *获取支付中心商品信息 
	 */
	public String getOrderCourse() {
		WebElement element = this.getElement(getByLocator.getLocator("orderCourse"));
		WebElement elementNode = this.getElement(element, getByLocator.getLocator("orderCourseNode"));
		return this.getCourseText(elementNode);
	}
	
	
	
	/*
	 * 下单流程4-8
	 */
//	@Test(dependsOnMethods={"testLogin"})
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
