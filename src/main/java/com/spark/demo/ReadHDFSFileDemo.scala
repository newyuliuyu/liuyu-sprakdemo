package com.spark.demo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * ClassName: ReadHDFSFileDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-19 下午4:55 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object ReadHDFSFileDemo {

  def main(args: Array[String]): Unit = {
    var con = new SparkConf().setMaster("local").setAppName("transformation-demo")
    var sc = new SparkContext(con)
    val linedata=sc.textFile("hdfs://bigdata1:9000//user/hadoop/input/wc.input")
    var words = linedata.flatMap(x=>x.split(" "))
    var words2 = words.map((_,1)).reduceByKey(_+_)
    words2.foreach(println)
    sc.stop()
  }

}
