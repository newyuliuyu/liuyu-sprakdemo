package com.demo

/**
  * ClassName: MapDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-11 下午5:01 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object MapDemo {

  case class Student(_name: String) {
    var name = _name

    override def toString: String = name
  }

  def main(args: Array[String]): Unit = {
    var dataMap: Map[String, Array[Student]] = Map();

    dataMap += ("a" -> Array(Student("1")))

    var data = dataMap.get("a")
    data match {
      case Some(values) => dataMap += ("a" -> values.:+(Student("2")))
      case None => println("没有值")
    }


    dataMap.foreach {
      case (e, i) => println(e, i)
    }

    var kk = Array(1, 2, 3)
    kk.foreach(x => println(x))
    println()
  }
}
