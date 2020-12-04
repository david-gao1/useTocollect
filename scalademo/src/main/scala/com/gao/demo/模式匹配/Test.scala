package com.gao.demo.模式匹配

import java.io.IOException

import com.gao.demo.模式匹配.匹配的种类01.MatchDemo


object Test {
  def main(args: Array[String]): Unit = {
    val demo = new MatchDemo
    demo.m2("1")
    demo.m3(new IOException)
    demo.m4()
  }

}
