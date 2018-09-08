package loginLayer.Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DriverBase {
	public WebDriver driver;
	public DriverBase(String browser) {
		this.driver  = new SelectDriver().driverName(browser);
	}
	
	public void stop() {
		System.out.println("浏览器关闭");
		driver.close();
	}
	
	/*
	 * 封装element
	 */
	public WebElement findelement(By by) {
		WebElement element = driver.findElement(by);
		return element;
	}
	
	public void get(String url) {
		driver.get(url);
	}

	/*
	 * 返回
	 */
	public void back() {
		driver.navigate().back();
	}
}
