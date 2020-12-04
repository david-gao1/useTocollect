package com.gao.demo.模式匹配.匹配的种类01

import java.io.{FileNotFoundException, IOException}

import scala.io.Source


class MatchDemo {
  /**
   * 变量值的匹配
   *
   * @param name
   */
  def m2(name: String) {
    name match {
      case "1" => println("周一")
      case "2" => println("周二")
      case _ => println("其他")
    }
  }

  /**
   * 常用在报错
   * 变量类型的赋值
   * 入参类型是"传参类型"的父类
   *
   * @param e ：
   */
  def m3(e: Exception): Unit = {
    e match {
      case e1: FileNotFoundException => println("FileNotFoundException" + e1)
      case e2: IOException => println("IOException" + e2)
      case _ => println("其他")

    }
  }

  /**
   * 使用在try catch
   */
  def m4() {

    try {
      val lines02 = Source.fromFile("D://test02.txt").mkString
    } catch {
      //省略了什么
      case _: FileNotFoundException => println("no file") //没有被使用可以用"_"代替
      case _: IOException => println("io exception")
      case _: Exception => println("exception")
    }
  }
}

object MatchDemo {
  def apply(): MatchDemo = new MatchDemo()
}
