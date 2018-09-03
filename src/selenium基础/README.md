# [Talk is cheap.*Show* me your *code*.](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/selenium%E5%9F%BA%E7%A1%80/ActionSelenium.java)
1. 环境

   - 环境配置不赘述
   - 创建项目，导入jar包不赘述
   - WebDriver driver;
   - [System.setProperty();](https://github.com/dqw6668/myStudy_in_seleniun/blob/master/src/selenium%E5%9F%BA%E7%A1%80/find_element.java)

2. HTML基础

   - html标签开头，html标签结尾
   - head部分
   - body部分，定位主要为body内的内容
   - ul列表，div分块，a标签=====

3. 十大定位方法

   - By.xpath

   - By.id
   - By.name
   - By.tagName
   - By.className
   - By.linkText
   - By.partialLinkText
   - By.cssSelector
   - 表格定位，层级定位

4. 元素处理方法

   - 文本框
     - sendKeys
     - clear
     - getAttribute
   - 单选框
     - click
     - clear
     - isSelected
   - 多选框
     - click
     - clear
     - isSelected
     - isEnabled
   - 按钮
     - click
     - isEnabled
   - 表单
     - submit（以url后？附加参数形势）
   - 上传文件
     - input以sendkey方式
     - autoIt
   - 下拉框
     - selenium自带select list = new select(locator)类
     - selectByText, selectByValue, selectByIndex
     - deselectAll, deselectByValue, deselectByIndex, deselectByVisibleText
     - getAllSelectedOptions, getFirstSelectedOption
   - 鼠标
     - Actions action = new Actions(driver)
     - Action.click().**perform()**每次都要有perform
     - contextClick().**perform()**, doubleClick()..**perform()**, moveToElement()..**perform()**
   - 窗口\体
     - iframe, 弹窗
     - switchTo(), getWindowHandles()
   - 等待函数
     - 强制等待--sleep死等
     - 显示等待--规定时间，一旦找到立刻下步
     - 隐式等待--相当于全局

ps：

1. 弄清楚selenium工作原理，clien，driver
2. 动态元素的定位？常用Xpath