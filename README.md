# MVPStructure-master —— MVP(Model-View-Presenter)开发模式

## MVP模式要点 ##
#### MVP模式一般包含四要素： ####
     (1)View:负责绘制UI元素、与用户进行交互(在Android中体现为Activity)
     (2)View interface:需要View实现的接口，View通过View interface与Presenter进行交互，降低耦合，方便进行单元测试
     (3)Model:负责业务逻辑和实体模型(主要职责是存储、检索、操纵数据，有时也实现一个Model interface用来降低耦合)
     (4)Presenter:负责完成View与Model间的交互(作为View与Model交互的中间纽带，处理与用户的交互)

#### MVP模式的优点： ####
      (1)降低耦合度
      (2)模块职责划分明显
      (3)利于测试驱动开发
      (4)代码复用
      (5)隐藏数据
      (6)代码灵活性

#### MVP模式的缺点： ####
      (1)层次多代码复杂
      (2)代码复杂

#### MVP模式的特点： ####
      (1)View不直接与Model交互，而是通过与Presenter交互来与Model间接交互
      (2)Presenter与View的交互是通过接口来进行的，更有利于添加单元测试
      (3)通常View与Presenter是一对一的，但复杂的View可能绑定多个Presenter来处理逻辑