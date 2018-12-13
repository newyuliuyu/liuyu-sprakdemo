package com.spark.demo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * ClassName: GroupByDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-11 下午3:03 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object GroupByDemo {
  def main(args: Array[String]): Unit = {
      val conf = new SparkConf().setAppName("demo-test")
      conf.setMaster("local")
      val sc = new SparkContext(conf)

    var list = createData();
    var rdd = sc.parallelize(list,4)
//    var rdd2 = rdd.groupByKey()
    var rdd2 = rdd.groupBy(x=>x._1)

    println(rdd2.partitions.size)
    var rdd3 = rdd2.map(x=>{
      val xx = x._1
      val yy=x._2
      (xx,yy.toList.sorted.reverse)
    })
    println(rdd3.partitions.size)
    var mm2 = rdd2.collect()
    var mm3 = rdd3.collect()
    for(mmm<-mm3){
      println()
    }
    println()

  }

  def createData() ={
    var list:List[(String,Int)] = List()
    list  = list:+("aa",78)
    list  = list:+("bb",98)
    list  = list:+("aa",80)
    list  = list:+("cc",98)
    list  = list:+("aa",69)
    list  = list:+("cc",87)
    list  = list:+("bb",97)
    list  = list:+("cc",86)
    list  = list:+("aa",97)
    list  = list:+("bb",78)
    list  = list:+("bb",34)
    list  = list:+("cc",85)
    list  = list:+("bb",92)
    list  = list:+("cc",72)
    list  = list:+("bb",33)
    list  = list:+("bb",23)
    list
  }
}
