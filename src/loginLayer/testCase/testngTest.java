package loginLayer.testCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class testngTest {
	@BeforeClass
	public void test01() {
		System.out.println("BeforeClass");
	}
	@BeforeMethod
	public void test02() {
		System.out.println("BeforeMethod");
	}
	@Test
	public void test03() {
		System.out.println("Test");
	}
	@Test
	public void test() {
		System.out.println("Test2");
	}
	@AfterMethod
	public void test04() {
		System.out.println("AfterMethod");
	}
	@AfterClass
	public void test05() {
		System.out.println("AfterClass");
	}

}
