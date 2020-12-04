package com.gao.demo.basic

import scala.io.Source

object WordCount {
  def main(args: Array[String]): Unit = {
    //计算有多少个单词
    val source = Source.fromFile("C:\\Users\\v_liangggao\\Desktop\\wc11.txt").getLines()
    val wcNum = source
      .flatMap(line => line.split(","))
      .map(word => Tuple2(word, 1))
      .map(wordTuple2 => wordTuple2._2).sum
    println(wcNum)
  }

}
