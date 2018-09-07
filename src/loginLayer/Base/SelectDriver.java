package loginLayer.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectDriver {
	public WebDriver driverName(String browserName) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\java\\project\\chromedriver_win32\\chromedriver.exe");
			return new ChromeDriver();
		}else {
			System.setProperty("webdriver.firefox.driver", "E:\\java\\project\\geckodriver\\geckodriver.exe");
			return new FirefoxDriver();
		}
	}
}
