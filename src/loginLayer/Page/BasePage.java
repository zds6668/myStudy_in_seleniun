package loginLayer.Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import loginLayer.Base.DriverBase;

public class BasePage {
	public DriverBase driver;
	public BasePage(DriverBase driver) {
		this.driver = driver;
	}
	
	/*
	 * 定位Element
	 * @param By by
	 */
	public WebElement element(By by) {
		WebElement element = driver.findelement(by);
		return element;
	}
	
	/*
	 * 层级定位，通过父节点定位到子
	 */
	public WebElement nodeElement(By by, By nodeby) {
		WebElement element = this.element(by);
		return element.findElement(nodeby);
	}
	
	/*
	 * 点击
	 */
	public void click(WebElement element) {
		if (element != null) {
			element.click();
		}else {
			System.out.println("点不到");
		}
	}
	
	/*
	 * 封装输入
	 */
	public void sendkeys(WebElement element, String key) {
		if (element != null) {
			element.sendKeys(key);
		}else {
			System.out.println(element + "定位不到");
		}
	}
	
	/*
	 * display
	 */
	public boolean isDispaly(WebElement element) {
		return element.isDisplayed();
	}
	
	/*
	 * 获取文本信息
	 */
	public String getText(WebElement element) {
		return element.getText();
	}
}
