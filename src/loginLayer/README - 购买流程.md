## Talk is cheap.*Show* me your code

## 初始实现流程

1. 功能需求一览：

![功能需求](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/pic/4-2%E6%B5%81%E7%A8%8B.png)

2. 功能用例：

![功能用例](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/pic/4-3%E5%8A%9F%E8%83%BD%E6%B5%8B%E8%AF%95%E7%94%A8%E4%BE%8B.png)

3. 自动化用例：

![自动化用例](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/pic/4-4%E8%87%AA%E5%8A%A8%E6%B5%8B%E8%AF%95%E7%94%A8%E4%BE%8B.png)

4. [遍历所有商品](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/testCase/testCourseList.java)testCourseList.java

   - 找到父节点，对每一个商品遍历
   - 页面变动便利的信息失效？遍历到商品描述，每次以contains(text()的方式遍历到商品

5. [Assert的测试](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/testCase/testAssert.java)

6. [下单流程](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/testCase/login.java#L128)

   - Assert（orderString, courseDetil）


### 重构

- 元素层-->获取元素
- 操作层-->购买
- 业务层-->逻辑判断

1. [login中封装获取element](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/testCase/login.java#L71)
   - 获取element，通过父节点取子节点
   - 获取课程信息，点击确定订单，获取订单号
   - 初步封装后的[下单流程](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/testCase/login.java#L47)
2. 课程Pageobject
   - 继承BasePage的[CoursePage](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Page/CoursePage.java)元素层
     - 获取各种element
     - 遇到需要层级定位，BasePage中封装[父节点获取子节点](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Page/BasePage.java#L24)
   - [CoursePageHandle](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Handle/CoursePageHandle.java)操作层
     - 实例化CoursePage
     - 封装各操作
     - BasePage中需要封装一个获取文本信息
   - [CoursePagePro](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Business/CoursePagePro.java)业务层
     - 拿到CoursePageHandle
     - 调用CoursePageHandle中的操作，对添加购物车前后做了逻辑判断
   - 购物车重复出现弹窗？如何自动点击
     - DriverBase里封装
     - switchToAlert发现并非aletr弹窗
     - switchToactiveElement

3. 订单Pageobject
   - [SureOrderPage](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Page/SureOrderPage.java)
   - [SureOrderHandle](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Handle/SureOrderHandle.java)
   - [SureOrderPagePro](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Business/SureOrderPagePro.java)

4. 支付Pageobject
   - [orderPayPage](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Page/orderPayPage.java)
   - [OrderPayPageHandle](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Handle/OrderPayPageHandle.java)
   - [OrderPayPagePro](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/Business/OrderPayPagePro.java)
5. testCase中的[login_po](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/loginLayer/testCase/login_po.java)
   - new CoursePagePro @Test(dependsOnMethods= 登录
   - new SureOrderPagePro @Test(dependsOnMethods= 上一步
   - new OrderPayPagePro @Test(dependsOnMethods= 上一步
6. case运行完毕，自动化测试报告，自动发送邮件