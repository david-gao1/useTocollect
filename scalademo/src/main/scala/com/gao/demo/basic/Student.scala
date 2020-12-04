package com.gao.demo.basic

object Student {
  private val hobby = "baseball"

}


class Student {
  private var name = "jack"
  private var age = 10

  def getHello(name: String, age: Int): Unit = {
    println("name:" + name + "," + "age" + age + "," + Student.hobby)
  }
}

