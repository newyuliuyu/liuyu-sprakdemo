package com.demo

import java.util.Date
/**
  * ClassName: FunDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-11 下午1:44 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object FunDemo {
  //函数调用传名调用
  def time(): Long ={
    println("获取时间，单位为纳秒")
    System.nanoTime
  }
  def delayed(t: =>Long){
    println("在 delayed 方法内")
    println("参数： " + t)
    t
  }
  //指定函数的参数名称
  def printInt( a:Int, b:Int ) = {
    println("***************printInt************************")
    println("Value of a : " + a );
    println("Value of b : " + b );
  }
  //函数可变参数
  def printArgs(values:String*): Unit ={
    println("***************printArgs************************")
    var i=0;
    for (value <- values){
      println("Arg value[" + i + "] = " + value)
      i+=1
    }
  }
  //默认值
  def addInt(a:Int=5,b:Int=5): Unit ={
    println("***************printArgs************************")
    println(a+"+"+b+"="+(a+b))
  }
  //高级函数
  def apply(f:Int=>String,v:Int) = {
    println("***************apply************************")
    f(v)
  }
  def myFun[A](v:A)={
    println("***************myFun************************")
    v.toString
  }
  //匿名函数
  var myFunVar = (x:Int)=>{
    println("***************这是匿名函数************************")
    "只是函数值:"+x
  }
  //偏函数
  def log(date: Date, message: String)  = {
    println(date + "----" + message)
  }
  //函数柯里化(Function Currying)
  def add(x:Int)(y:Int)={
    x+y
  }
  def add2(x:Int)(y:Int)(n:Int)={
    x+y+n
  }
  def main(args: Array[String]): Unit = {
    delayed(time())
    printInt(b=10,a=20)
    printArgs("Runoob", "Scala", "Python")
    addInt()
    addInt(b=10)
    println(apply(myFun,10))
    var funValue = myFunVar(10)
    println(funValue)
    //偏函数应用
    val date = new Date
    val logWithDateBound = log(date, _ : String)
    logWithDateBound("message1")
    Thread.sleep(1000)
    logWithDateBound("message2")
    Thread.sleep(1000)
    logWithDateBound("message3")

    println(add(10)(5))
    val myvalue1 = add(10)(_)
    println(myvalue1(5))
    println(add2(10)(5)(20))
  }
}
