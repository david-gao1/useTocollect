package com.gao.demo.accompany

class Person(val name: String) {
  def getHello(): Unit = {
    println("name:" + name)
  }
}

object Person {
  def apply(name: String) = {
    println("apply exec...")
    new Person(name)
  }
}
