/**
  * ClassName: ScaleDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-8 下午4:58 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object ScaleDemo {
  // 函数 f 和 值 v 作为参数，而函数 f 又调用了参数 v
  def apply(f: (Int, Int) => String, v: Int, n: Int) = f(v, n)

  def layout[A](x: A, y: A) = {
    "[" + x.toString() + "," + y.toString + "]"
  }

  def inc = (x: Int) => {
    println(x)
    x * 2
  }

  def person(implicit name: String): Unit = {
    println(name)
  }
  def person2(name: String): Unit = {
    println(name)
  }

  implicit def intToString(x: Int): String = {
    x.toString()
  }



  def main(args: Array[String]): Unit = {
    println(apply(layout, 10, 20))
    println(inc(10))
    var a = "10"
    println(a.getClass.toString)

    implicit var value = "fdfdjf"
    person
    var k = 10
    person2(k)
  }
}
