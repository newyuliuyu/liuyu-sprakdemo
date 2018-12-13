package com.demo

/**
  * ClassName: ListDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-11 下午6:04 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object ListDemo {

  def add(data:List[String]): Unit ={
    var kk = data :+ "abdf"
    var m  = List()
    m :+ "abd"
    println()
  }

  def myMap(data:Map[String,String]): Unit ={
    var tmpMap:Map[String,String] = Map()
    tmpMap+=("a"->"b")
    var m  = List()
    m:+"abd"
  }
  def main(args: Array[String]): Unit = {
    add(List("a","b"))
  }
}
