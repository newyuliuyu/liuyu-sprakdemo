package com.spark.demo

import org.apache.spark.{SparkConf, SparkContext}

/**
  * ClassName: SprakTransformationDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-15 下午2:47 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object SprakTransformationDemo {

  def getList(): List[Int] = {
    var list = List[Int]()
    for (i <- 1 to 100) {
      list = (new util.Random).nextInt(100) +: list
    }
    return list
  }

  def main(args: Array[String]): Unit = {
    var con = new SparkConf().setMaster("local").setAppName("transformation-demo")
    var sc = new SparkContext(con)

    var rdd11 = sc.makeRDD(1 to 5, 2)
    var rdd12 = sc.makeRDD(Seq("A", "B", "C", "D", "E"), 2)
    rdd11.zip(rdd12).foreach(println)

    var rdd13 = rdd11.zipPartitions(rdd12) {
      (rdd1Iter, rdd2Iter) => {
        var result = List[String]()
        while (rdd1Iter.hasNext && rdd2Iter.hasNext) {
          result ::= (rdd1Iter.next() + "_" + rdd2Iter.next())
        }
        result.iterator
      }
    }
    rdd13.foreach(println)


    //    var a="a,b,c,d"
    //    var rdd = sc.parallelize(Seq(a))
    //    var rdd2 = rdd.map(x=>x.split(","))
    //    var rdd3= rdd2.flatMap(xs=>{
    //      var b = List[String]()
    //      for(m<-xs){
    //        b=b:+m+m+m
    //      }
    //      println(b)
    //      b
    //    })
    //    rdd2.foreach(println)
    //    rdd3.foreach(println)

    //    println(rdd3.partitions.size)


    //    var list = getList()
    //    var rdd = sc.parallelize(list)
    //    rdd.foreach(println)
    //    var rdd2 = rdd.sortBy(x=>x)
    //    rdd2.foreach(println)
    //    var rdd3 = rdd2.takeOrdered(10)
    //    rdd3.foreach(println)
    //    var rdd4 = rdd2.top(10)
    //    rdd4.foreach(println)


    //    val arry = List((1,2),(3,4),(3,6))
    //    var rdd = sc.parallelize(arry)
    //    var rdd2 = rdd.sortBy(x=>x._2,false)
    //    rdd2.foreach(println)


    //    val arr = List(("A", 1), ("B", 2), ("A", 2), ("B", 3))
    //    val arr1 = List(("A", "A1"), ("B", "B1"), ("A", "A2"), ("B", "B2"))
    //    val rdd1 = sc.parallelize(arr, 3)
    //    val rdd2 = sc.parallelize(arr1, 3)
    //    val groupByKeyRDD = rdd1.cogroup(rdd2)
    //    groupByKeyRDD.foreach(println)


    //    val arr = List(("A",3),("A",2),("A",2),("B",1),("B",3))
    //    val rdd = sc.parallelize(arr)
    //    val reduceByKeyRDD = rdd.reduceByKey((x,y)=>{
    //      println(x+"===="+y)
    //      x+y
    //    })
    //    reduceByKeyRDD.foreach(println)

    //    val people = List(("Mobin", 2), ("Mobin", 1), ("Lucy", 2), ("Amy", 1), ("Lucy", 3))
    //    val rdd = sc.parallelize(people)
    //    val foldByKeyRDD = rdd.foldByKey(2)(_+_)
    //    foldByKeyRDD.foreach(println)


    //    var list = List(("a",1),("b",2),("c",3))
    //    var rdd = sc.parallelize(list)
    //    val mapValuesRDD = rdd.flatMapValues(x => Seq(x,"male"))
    //    mapValuesRDD.foreach(println)
    //    val mapValuesRDD2 = rdd.mapValues(x=>Seq(x,"male"))
    //    mapValuesRDD2.foreach(println)


    //    val people = List(("male", "Mobin"), ("male", "Kpop"), ("female", "Lucy"), ("male", "Lufei"), ("female", "Amy"))
    //    var rdd = sc.parallelize(people)
    //    val combinByKeyRDD = rdd.combineByKey(
    //      (x: String) => (List(x), 1),
    //      (peo: (List[String], Int), x : String) => (x :: peo._1, peo._2 + 1),
    //      (sex1: (List[String], Int), sex2: (List[String], Int)) => (sex1._1 ::: sex2._1, sex1._2 + sex2._2))
    //    combinByKeyRDD.foreach(println)


    sc.stop()
  }
}
