package selenium基础;

import java.awt.Checkbox;
import java.awt.Desktop.Action;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionSelenium {
	public WebDriver driver;
	
	public void InitDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\java\\project\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.imooc.com");
//		driver.manage().window().maximize();
	}
	
	
	/**
	**封装sleep
	**/
	private void sleep(int sleeptime) {
		try {
			Thread.sleep(sleeptime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	**输入框
	**/
	private void inputBox() {
		// TODO Auto-generated method stub
		driver.get("https://www.imooc.com/user/newlogin");
		driver.findElement(By.name("email")).sendKeys("18291857993");
		
		driver.findElement(By.name("email")).clear();
		String s = driver.findElement(By.name("email")).getAttribute("placeholder");
		System.out.println(s);
		driver.findElement(By.name("email")).sendKeys("18291857993");
		driver.findElement(By.name("password")).sendKeys("19970505");
//		driver.findElement(By.className("moco-btn-lg")).click();
		sleep(2000);
	}

	
	/**
	**单选框
	**/
	public void radioBox() {
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.className("pull-right")).click();
//		driver.findElement(By.xpath("//*[@id=\"profile\"]/div[4]/div/label[2]/input")).click();
		//定位到三个label的父标签
		List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"profile\"]/div[4]/div/label//input"));
		System.out.println(elements.size());
		sleep(2000);
		for(WebElement radio:elements) {
			boolean flag = radio.isSelected();
			if (flag == false) {
				radio.click();
				break;
			}else {
				System.out.println(radio+"选中了");
				}
			}
		}
				
	
	/**
	**多选框
	**/
	public void checkBox() {
		WebElement check = driver.findElement(By.id("auto-signin"));
		System.out.println("是否选中" + check.isSelected());
		System.out.println("是否有效" + check.isEnabled());

	}
	
	
	/**
	**按钮
	**/
	public void button() {
		WebElement login = driver.findElement(By.className("moco-btn"));
		System.out.println(login.isEnabled());
		System.out.println(login.getAttribute("value"));
		login.click();
		sleep(2000);
	}
		
	
	/**
	**按钮
	**/
	public void webForm() {
		driver.findElement(By.id("signup-form")).submit();
		//是以url后加?附加参数提交的。。。
	}
	
	
	/**
	 * 上传文件
	 */
	public void upHeader() {
		driver.get("https://www.imooc.com/user/setbindsns");
		// 修改头像按钮是不可见的，怎么处理
		sleep(2000);
		
		String jsString = "document.getElementsByClassName('update-avator')[0].style.bottom='0'";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript(jsString);
		sleep(2000);
		driver.findElement(By.className("js-avator-link")).click();
		driver.findElement(By.id("upload")).sendKeys("C:\\Users\\deng\\Pictures\\v2-482f52d660a9c41a0c0bec895d662b99_r.jpg");
	}
	
	
	/***
	 * 下拉框
	 */
	public void downSelectBox() {
		driver.get("https://www.imooc.com/user/setprofile");
		driver.findElement(By.className("pull-right")).click();
		sleep(2000);
		WebElement formElement = driver.findElement(By.id("profile"));
		WebElement job = formElement.findElement(By.id("job"));
		Select downlist = new Select(job);
		downlist.selectByValue("8");
//		downlist.deselectByValue("8");
		//拿到的是select option
		System.out.println(downlist.getAllSelectedOptions());
		System.out.println(downlist.getFirstSelectedOption().getText());
	}
	
	
	/*
	 * 鼠标操作
	 */
	public void mouseAction() {
//		WebElement login = driver.findElement(By.id("js-signin-btn"));
		WebElement elements = driver.findElement(By.className("menuContent"));
		List<WebElement> item = elements.findElements(By.className("item"));
		
		Actions action = new Actions(driver);
//		action.click(login).perform();
		action.moveToElement(item.get(0)).perform();
		sleep(2000);
//		action.doubleClick(login).perform();
	}
	
	
	/*
	 * iframe切换操作
	 */
	public void iframe() {
		driver.get("https://www.imooc.com/wiki/create");
		WebElement iframeElement = driver.findElement(By.id("ueditor_0"));
		driver.switchTo().frame(iframeElement);
		driver.findElement(By.tagName("body")).sendKeys("哈哈，我也试试");
	}
	
	
	/*
	 * 窗口
	 */
	public void windowsHandle() {
		Set<String> handles = driver.getWindowHandles();
		for(String s:handles) {
			driver.switchTo().window(s);
		}
			
	}
	
	
	/*
	 * 等待分类
	 */
	public void waitforElement() {
		//sleep即算强制 死等
		//隐式 全局时间
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//显示，如果规定时间找到继续，1s找到也立刻继续
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("idtest")));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ActionSelenium as = new ActionSelenium();
		as.InitDriver();
//		as.checkBox();
//		as.inputBox();
//		as.button();
//		as.radioBox();
//		as.upHeader();
//		as.downSelectBox();
//		as.mouseAction();
//		as.iframe();
//		as.windowsHandle();
		as.waitforElement();
	}

}
