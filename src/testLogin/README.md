---
typora-root-url: pic
---

## Talk is cheap.*Show* me your code

### project tree

1. login.java，最原始的实现

2. 

## 初步testLogin

1. 功能点![3-1](/3-1.png)

2.自动化用例![3-5测试用例](/3-5测试用例.png)

3. 引入Maven
4. [login.java](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/login.java)
   - 初始化driver
   - 一个loginScript写完全部用例代码![login登陆成功](/login登陆成功.png)
5. 重构为[loginPro.java](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/loginPro.java)
   - [By.by的封装](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/LoginPro.java#L107)
     - return By.xxxx
   - [findelement的封装](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/LoginPro.java#L131)
     - driver.findelement->element
     - 要查找的element参数化
   - [配置文件的封装](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/ProUtil.java)
     - ProUtil.java 读取配置文件代码，构造方法
     - [element.properties](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/element.properties)中以 键>值 存储的是findelement.By.<**key**>("<**value**>"); 中用的键值
     - [key>value的处理](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/LoginPro.java#L110)封装到By中
   - 若测多个账号，[hashmap](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/LoginPro.java#L149)实现帐号密码参数化
6. [testNG](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/LoginPro.java#L139)
   - 在selenium驱动基础上引入testng
   - 更好的管理case？
   - @Test(dependsOnMethods)
7. TestngListenerScreenShot.java自动截图
   - selenium的takeScreenShot方法
   - 以date命名
   - [事件监听TestListenerAdapter](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/TestngListenerScreenShot.java)重写onTestFailure实现失败自动截图
   - 需要driver调用截图，封装截图方法到[baseDriver.java](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/testLogin/baseDriver.java#L22)中
   - @Listeners事件监听

## 分层设计