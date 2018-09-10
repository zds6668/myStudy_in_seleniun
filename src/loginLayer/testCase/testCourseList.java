package loginLayer.testCase;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import loginLayer.Base.DriverBase;

public class testCourseList extends CaseBase{
	public DriverBase driver;
	public testCourseList() {
		this.driver = InitDriver("chrome");
	}
	
	@Test
	public void CourseList() {
		driver.get("https://coding.imooc.com/");
		List<String> listString = this.listElement();
		for(int i = 0;i<listString.size();i++) {
			driver.findelement(By.xpath("//*[contains(text(),'"+listString.get(i)+"')]")).click();
			driver.back();
		}
	}
	
	/*
	 * 获取所有课程list
	 */
	public List<String> listElement(){
		List<String> listString = new ArrayList<String>();
		WebElement element = driver.findelement(By.className("shizhan-course-list"));
		List<WebElement> listElement = element.findElements(By.className("shizhan-course-box"));
		for(WebElement el:listElement) {
			listString.add(el.findElement(By.className("shizan-desc")).getText());
		}
		return listString;
	}
}
