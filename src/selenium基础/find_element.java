package selenium基础;

import java.util.List;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class find_element {

	public static void main(String[] args) {
		WebDriver driver;
		// TODO Auto-generated method stub
		System.setProperty ( "webdriver.gecko.driver" , "E:\\java\\project\\geckodriver\\geckodriver.exe" );
		driver = new FirefoxDriver();
		driver.get("https://www.imooc.com/user/newlogin");
		driver.findElement(By.name("email")).sendKeys("18291857993");
		driver.findElement(By.name("password")).sendKeys("19970505");
		driver.findElement(By.id("auto-signin")).click();
		driver.findElement(By.className("moco-btn")).click();
		driver.manage().window().maximize();
		driver.findElement(By.className("search-input")).click();
		driver.findElement(By.className("search-input")).sendKeys("自动测试");
		WebElement element = driver.findElement(By.className("nav-item"));
		List<WebElement> elements = element.findElements(By.tagName("li"));
		elements.get(3).click();
		
	}

}
