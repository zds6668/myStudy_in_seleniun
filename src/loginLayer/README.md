## Talk is cheap.*Show* me your code

## LoginPro分层设计

### 代码冗余、重复，PO模型pageobject

- 元素层-->获取元素
- 操作层-->输入账户密码
- 业务层-->逻辑判断

### 基础围绕driver的封装

1. 基类 [.Base](https://github.com/dqw6668/myStudy_in_seleniun/tree/master/src/loginLayer/Base)

   - SelectDriver.java-->根据brow选择driver（chrome？firefox？更多。。）
   - DriverBase.java-->生成driver
     - 封装stop，get，findelement

2.  [.Util](https://github.com/dqw6668/myStudy_in_seleniun/tree/master/src/loginLayer/Util)

   - getByLocator.java

     - 从配置文件读取key-->value

     - 封装好的By，返回By.<**key**>("<**value**>")

3. 元素层 [.Page](https://github.com/dqw6668/myStudy_in_seleniun/tree/master/src/loginLayer/Page)

   - 在BasePage拿到DriverBase

   - 在BasePage中封装

     - 封装findelement为element

     - click，sendkeys，isdisplay

   - loginPage.java继承BasePage

     - 封装 get各种element

4. 操作层 [.Handle](https://github.com/dqw6668/myStudy_in_seleniun/tree/master/src/loginLayer/Handle)

   - loginPageHandle.java
     - 实例化loginPage.java的loginPage
     - sendName，sendPassword，click
     - 封装 对登录框isdisplay的判断方法

5. 业务层 [.Business](https://github.com/dqw6668/myStudy_in_seleniun/tree/master/src/loginLayer/Business)

   - LoginPro.java拿到loginPageHandle.java

     - 登录框，按钮存在的判断，检测到才登录

     - 登录

6. 用例包 [.testCase](https://github.com/dqw6668/myStudy_in_seleniun/tree/master/src/loginLayer/testCase)

   - CaseBase.java通过DriverBase通用生成driver
   - login.java登陆的case
     - new LoginPro
     - get到url，打开登录框，输入登录
   - 至此，分层基本完毕，以testng进行测试，pageobject完成
   - ![3-20](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/pic/3-20run.png)

7. 日志的收集及测试报告

   - 配置这些就不写了，网上也比较多

   - log生成用了开源的log4j![log](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/pic/3-21log4j.png)

   - testng自动有测试报告生成，看起来不太友好，没有图表，用testng-xslt进行美化
