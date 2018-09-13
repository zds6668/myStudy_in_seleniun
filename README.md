# myStudy_in_seleniun
以前就在学习自动化，一直觉得分享理思路很麻烦，不想去写md。以前博客也是，现在做个整理吧，也算给自己一个交代
<br>以前闲的时候不做，当没时间才抽时间逼自己。最近秋招也是挺累的

run，浏览器就自动执行，心也跟着起舞~
<br>

以前嫌分享麻烦，现在我低头。<br>

记录自己selenium的学习<br>



# studyTree



## 环境

jdk1.8、selenium 3.1、ide eclipse ee、testng 6.14、maven 3.5.4、chromedriver、log4j 1.2、

## [selenium基础](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/selenium%E5%9F%BA%E7%A1%80/README.md)

1. Setproperty、环境

2. html的组成

3. 元素定位

4. 元素处理

   complete 9月4日 02:35:10

## 登录测试

1. [最初的测试功能实现](https://github.com/dqw6668/myStudy_in_seleniun/tree/master/src/testLogin)**testLogin**

   - 登录需求分析，功能点，注意用户体验
   - 自动化测试用例
   - 依赖管理Maven
   - 用例到loginScript
   - 代码重构，封装By
   - 封装findelement
   - 从配置文件读取properties
   - 帐号密码参数化，hashmap
   - 引入自动化测试框架Testng
   - 自动截图方法，事件监听截图

2. [对最初版本代码分层设计](https://github.com/dqw6668/myStudy_in_seleniun/tree/master/src/loginLayer)**loginLayer**

   - 元素层

   - 操作层

   - 业务层

   - 日志收集，测试报告生成

     complete 9月8日 00:03:46

## 购买测试

1. 购买流程实现 初始版
   - 购物需求分析，功能用例，自动化用例
   - 遍历到所有商品
   - 用到Assert
   - 下单流程实现
2. 重构
   - 课程页面PO
   - 确认订单页面PO
   - 支付中心页面PO

## testNG

## CI持续集成

## 框架拓展

## 自动化框架封装及优化

## selenium的python应用
