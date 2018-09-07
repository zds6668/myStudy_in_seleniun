package testLogin;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class baseDriver {
	WebDriver driver;
	public baseDriver() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", "E:\\java\\project\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	
	/*
	 * 截图 12)
	 */
	public void takeScreenShot() {
		long date = System.currentTimeMillis();
		String path = String.valueOf(date);
		String curPath = System.getProperty("user.dir");
		path = path +".png";
		String screenPath = curPath + "/" + path;
		File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			Files.copy(screen, new File(screenPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}System.out.println("截图了");
	}
	
}
