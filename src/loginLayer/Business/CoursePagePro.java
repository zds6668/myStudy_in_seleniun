package loginLayer.Business;

import loginLayer.Base.DriverBase;
import loginLayer.Handle.CoursePageHandle;

public class CoursePagePro {
	public DriverBase driver;
	public CoursePageHandle coursePageHandle;
	public CoursePagePro(DriverBase driver) {
		this.driver = driver;
		coursePageHandle = new CoursePageHandle(driver);
	}
	
	/*
	 * 添加购物车
	 */
	public void addCart() {
		int beforeNum = 0;
		int afterNum = 0;
		String aftercourseNum;
		String courseNum = coursePageHandle.getShopCartNum();
		try {
			beforeNum = Integer.valueOf(courseNum);
		}catch (Exception e) {
			// TODO: handle exception
			beforeNum = 0;
		}
		coursePageHandle.clickAddCart();
		
		try {
			driver.switchToMode();
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		coursePageHandle.clickBuyNow();
		aftercourseNum = coursePageHandle.getShopCartNum();
		try {
		    afterNum = Integer.valueOf(aftercourseNum);
		}catch (Exception e) {
			// TODO: handle exception
			afterNum = beforeNum;
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (afterNum == beforeNum + 1) {
			System.out.println("添加购物车成功");
			coursePageHandle.clickAddCart();
		}else if (afterNum>0) {
			coursePageHandle.clickAddCart();
		}
	}
	
	/*
	 * 点击立即购买
	 */
	public void buyNow() {
		// TODO Auto-generated method stub
		coursePageHandle.clickBuyNow();
	}
}
