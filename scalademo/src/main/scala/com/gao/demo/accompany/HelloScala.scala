package com.gao.demo.accompany

object HelloScala {
  def main(args: Array[String]): Unit = {
    printf("hello scala!")
    //访问私有值
    //val student = new Student()
    //student.getHello("xiaoxiao",12)

    //apply测试
    new Person("xiao").getHello()
    Person("da").getHello()

  }

}
