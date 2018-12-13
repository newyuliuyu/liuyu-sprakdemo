package com.demo

/**
  * ClassName: TupleDemo <br/>
  * Function:  ADD FUNCTION. <br/>
  * Reason:  ADD REASON(可选). <br/>
  * date: 18-6-11 下午4:01 <br/>
  *
  * @author liuyu
  * @version v1.0
  * @since JDK 1.7+
  */
object TupleDemo {

  case class Student(_name: String, _className: String, _score: Int) {
    var className: String = _className
    var score: Int = _score
    var name = _name

    override def toString: String = name + "=" + className + "==" + score
  }

  def createStuent() = {
    var students: Array[Student] = Array()
    var className = "";
    for (i <- 1 to 100) {
      if (i < 30) {
        className = "1班"
      } else if (i < 60) {
        className = "2班"
      } else {
        className = "3班"
      }
      var score = (new util.Random).nextInt(100)
      students = Student("学生" + i, className, score) +: students
    }
    students
  }

  def groupBy(dataset: Array[Student]): Unit = {
    var csm: Map[String, Array[Student]] = Map();
    dataset.foreach(x => {
      var className = x.className
      csm.get(className) match {
        case None => csm += (className -> Array(x))
        case Some(values) => csm += (className -> (x +: values))
      }
    })

    for((key,values)<-csm){
      var students = values
      students = students.sortBy(x => x.score)
      students = students.reverse
      var datas = students.take(10)
      println("班级" + key + "前10名学生")
      datas.foreach(println(_))
      students = students.reverse
      datas = students.take(10)
      println("班级" + key + "后10名学生")
      datas.foreach(println(_))
    }


  }

  def main(args: Array[String]): Unit = {
    var dataset = createStuent()
    groupBy(dataset)
    //    dataset = dataset.sortBy(x=>(x.className,x.score))(Ordering.Tuple2(Ordering.String,Ordering.Int))
    //
    //    for (row<-dataset){
    //      println(row)
    //    }
  }
}
