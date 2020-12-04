package com.gao.demo.隐式转换.自动引入之伴生类01

object CatchMouse {
  def main(args: Array[String]): Unit = {
    val huanhuan = new Dog("hanan")
    //因为伴生对象有隐式转换，所以会直接自动调用隐式转换
    //使能够调用（因为返回值是Cat对象）cat的方法
    huanhuan.catchMouse()
  }
}
