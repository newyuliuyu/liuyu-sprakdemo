package com.demo

/**
  * ClassName: ScalaImplicitDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-11 下午1:24 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object ScalaImplicitDemo {
  //隐式参数
  def myFun(implicit myValue:String): Unit ={
    println(myValue)
  }
  //隐式函数
  implicit def intToString(value:Int):String={
    return "我是被intToString函数转换的值:"+value.toString
  }
  class SwingType{
    def  wantLearned(sw : String) = println("兔子已经学会了"+sw)
  }
  class AminalType{}
  implicit def learningType(s : AminalType) = new SwingType
  //隐式类
  implicit class MyName(x:Int){
    val y=x;
    print("我是一个隐式类,")
    println("我的值为:"+x)
  }

  def sayMyName(name:MyName): Unit ={
    println(name.y)
  }

  def main(args: Array[String]): Unit = {
    //隐式参数调用
    implicit val value:String="我的隐式参数值"
    myFun
    myFun(10)
    sayMyName(10)
    val rabbit = new AminalType
    rabbit.wantLearned("breaststroke")
  }
}
