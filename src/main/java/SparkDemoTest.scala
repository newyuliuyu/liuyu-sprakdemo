import org.apache.spark.{SparkConf, SparkContext}

/**
  * ClassName: DemoTest <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-8 下午4:12 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object SparkDemoTest {

  def main(args: Array[String]): Unit = {
    val conf = new SparkConf().setAppName("demo-test")
    conf.setMaster("local")
    val sc = new SparkContext(conf)

    var rdd = sc.textFile("/home/liuyu/workeidea/liuyusprakdemo/src/main/resources/input.txt")

    var rdd2 = rdd.map(line => {
      println(line)
      line.split("\\s+")
    })

    var count = rdd.count()
    println(count)
    var arry = rdd.partitions
    println(arry.length + "-----" + arry.size)
    for (row <- rdd) {
      println(row)

    }
    for (row <- rdd2) {
      println(row.length)
      for(value<-row){
        print(value+"-->")
      }
      println()
    }

    println()
  }

}
