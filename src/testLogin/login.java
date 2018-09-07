package testLogin;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;




public class login {
	public WebDriver driver;
	
	public void initDriver() {
		System.setProperty("webdriver.chrome.driver", "E:\\java\\project\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://www.imooc.com");
//		driver.manage().window().maximize();
	}
	
	
	public void loginScript() {
		driver.findElement(By.id("js-signin-btn")).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		WebElement user = driver.findElement(By.name("email"));
		user.isDisplayed();
		WebElement password = driver.findElement(By.name("password"));
		password.isDisplayed();
		WebElement loginButton = driver.findElement(By.className("moco-btn-lg"));
		user.sendKeys("18291857993");
		password.sendKeys("19970505");
		loginButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement header = driver.findElement(By.id("header-avator"));
		header.isDisplayed();
		Actions actions = new Actions(driver);
		actions.moveToElement(header).perform();
		String userInfo = driver.findElement(By.className("name")).getText();
		System.out.println(userInfo);
		if (userInfo.equals("你是个儿吗")) {
			System.out.println("登陆成功");
		}
		
	}
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		login login = new login();
		login.initDriver();
		login.loginScript();
	}

}
