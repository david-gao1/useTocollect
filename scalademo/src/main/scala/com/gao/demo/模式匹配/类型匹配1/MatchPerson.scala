package com.gao.demo.模式匹配.类型匹配1

/**
 * 匹配模式之类型（继承类）匹配
 *
 */
object MatchPerson {
  def main(args: Array[String]): Unit = {
    match1(Student("xi","class1"))
  }

  def match1(per: Person): Unit = {
    per match {
      case t: Teacher => println("Teacher, name is " + t.name + ", sub is " + t.sub)
      case stu: Student => println("Teacher, name is " + stu.name + ", sub is " + stu.cla)
    }
  }

}
