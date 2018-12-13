/**
  * ClassName: HelloWorld <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-7 下午4:09 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
import org.apache.spark.{SparkConf,SparkContext}
object HelloWorld {
  def main(args: Array[String]): Unit = {
    println("=================liuyu================================")
    println(args.length)
    for(kk <- args){
      println(kk)
    }
    println("======================liuyu===========================")
    val conf = new SparkConf().setAppName("mySpark")
//    conf.setMaster("spark://bigdata1:7077")
//    conf.setMaster("local")
    val sc = new SparkContext(conf)

    val rdd = sc.parallelize(List(1,2,3,4,5,6)).map(_*3)

    val mappedRDD=rdd.filter(_>10).collect()
    println("=================liuyu================================")
    println("applicationId"+sc.applicationId)
    //对集合求和
    println(rdd.reduce(_+_))
    //输出大于10的元素
    for(arg <- mappedRDD)
      print(arg+" ")
    println()
    println("math is work")
    println("=================liuyu================================")
  }
}
