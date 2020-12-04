package com.gao.demo.basic

class PersonWithTrait extends Hello with MakeFriend {
  def sayHello(name: String): Unit = {
    println("hello:" + name)
  }

  def makefriend(name1: String, name2: String): Unit = {
    println("hello:" + name1 + " and hi:" + name2)
  }
}
