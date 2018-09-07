package testLogin;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;



@Listeners({TestngListenerScreenShot.class})
public class LoginPro extends baseDriver{
	
	public void initDriver() {
		String url = "https://www.imooc.com";
		System.setProperty("webdriver.chrome.driver", "E:\\java\\project\\chromedriver_win32\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.get(url);
//		driver.manage().window().maximize();
		driver.findElement(By.id("js-signin-btn")).click();
	}
	
	
	public void loginScript(String name,String pass) {
		this.initDriver();
		/*账号密码封装出来
		String name = "18291857993";
		String pass = "19970505";*/
//		String passElement = "password";
//		String emailElement = "email";
//		String buttonElement = "moco-btn-red";
//		String headerElement = "header-avator";
//		String nameElement = "name";
//		String userBy = "name";
		/*
		 * 读取配置文件 8)
		 */
		/* 9) 移步到By
		ProUtil properties = new ProUtil("E:\\java\\project\\demo\\src\\testLogin\\element.properties") ;
		String locator = properties.getPro("name");
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1]; */
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement user = this.element(this.byStr("name"));
		user.isDisplayed();
		WebElement password = this.element(this.byStr("userpass"));
		password.isDisplayed();
//		WebElement loginButton = driver.findElement(By.xpath("//*[@id=\"signup-form\"]/div[5]/input"));
		WebElement loginButton = driver.findElement(By.className("moco-btn-lg"));
		user.sendKeys(name);
		password.sendKeys(pass);
//		String jsString = "document.getElementsByClassName(\"moco-btn-lg\").hidefocus=\"false\"";
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript(jsString);
		loginButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement header = this.element(this.byStr("header"));
		header.isDisplayed();
		Actions actions = new Actions(driver);
		actions.moveToElement(header).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		String userInfo = this.element(this.byStr("nameElement")).getText();
		System.out.println(userInfo);
		if (userInfo.equals("你是个儿吗")) {
			System.out.println("登陆成功");
//			this.takeScreenShot();
		}else {
			System.out.println("登录失败");
		}
		driver.close();
		}
		
	}
	
	
	/*
	 * 封装By 6)
	 */
	/*
	 * 配置文件封装 9)
	 */
	public By byStr(String key) {
		ProUtil properties = new ProUtil("E:\\java\\project\\demo\\src\\testLogin\\element.properties") ;
		String locator = properties.getPro(key);
		String locatorType = locator.split(">")[0];
		String locatorValue = locator.split(">")[1];
		
		if(locatorType.equals("id")) {
			return By.id(locatorValue);
		}else if (locatorType.equals("name")) {
			return By.name(locatorValue);
		}else if (locatorType.equals("className")) {
			return By.className(locatorValue);
		}else {
			return By.xpath(locatorValue);
		}
	}
	
	
	/*
	 * 封装element 7)
	 */
	public WebElement element(By by) {
		WebElement ele = driver.findElement(by);
		return ele;	
	}
	
	@Test
	public void loginpage() throws Exception{
		this.loginScript("18291857993", "19970505");
		
	}
	/*public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		LoginPro login = new LoginPro();
//		login.loginScript();
		
		/*
		 * 帐号密码封装10)
		 *
		HashMap<String, String> user = new HashMap<String, String>();
		user.put("18291857993", "19970505");
		Iterator us = user.entrySet().iterator();
		while(us.hasNext()) {
			Map.Entry entry = (Map.Entry) us.next();
			String username = entry.getKey().toString();
			String password = entry.getValue().toString();
			login.loginScript(username, password);
		}
	}*/
	
	
	
}
