package com.gao.scala.batch.dataset.transformation

import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}

/**
 * 外连接：三种情况
 * 1、leftouterjoin
 * 2、rightouterjoin
 * 3、fullouterjoin
 */

object BatchOuterJoinScala {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    //source:
    import org.apache.flink.api.scala._
    val text1 = env.fromCollection(Array((1, "jack"), (2, "tom"), (3, "mick"))) //初始化第一份数据 Tuple2<用户id,用户姓名>
    val text2 = env.fromCollection(Array((1, "bj"), (2, "sh"), (4, "gz"))) //初始化第二份数据 Tuple2<用户id,用户所在城市>

    useLeftjoin(text1, text2)
    useFullJoin(text1, text2)


  }


  private def useFullJoin(text1: DataSet[(Int, String)], text2: DataSet[(Int, String)]): Unit = {
    import org.apache.flink.api.scala._
    text1.fullOuterJoin(text2)
      .where(0)
      .equalTo(0) {
        (first, second) => {
          if (first == null) {
            (second._1, second._2, "null")
          } else if (second == null) {
            (first._1, first._2, "null")
          } else {
            (first._1, first._2, second._2)
          }
        }
      }.print()
  }

  /**
   * 以左边的数据开始遍历去匹配右边的数据
   * rightOuterJoin类似
   *
   * @param text1
   * @param text2
   */
  private def useLeftjoin(text1: DataSet[(Int, String)], text2: DataSet[(Int, String)]): Unit = {
    import org.apache.flink.api.scala._
    text1.leftOuterJoin(text2)
      .where(0)
      .equalTo(0) {
        //注意：当右边的数据匹配不到左边时，second中的元素可能为null
        (first, second) => {
          if (second == null) {
            (first._1, first._2, "null")
          } else {
            (first._1, first._2, second._2)
          }
        }
      }.print()
  }


}
