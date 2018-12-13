package com.demo

/**
  * ClassName: SorteDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-11 下午2:27 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object SorteDemo {

  def main(args: Array[String]): Unit = {
    val xs=Seq(1,5,3,4,6,2)
    println("==============sorted排序=================")
    println(xs.sorted) //升序
    println(xs.sorted.reverse) //降序
    println("==============sortBy排序=================")
    println( xs.sortBy(d=>d) ) //升序
    println( xs.sortBy(d=>d).reverse ) //降序
    println("==============sortWith排序=================")
    println( xs.sortWith(_<_) )//升序
    println( xs.sortWith(_>_) )//降序
  }
}
