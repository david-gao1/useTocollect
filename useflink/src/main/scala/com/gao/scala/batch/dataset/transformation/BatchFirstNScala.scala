package com.gao.scala.batch.dataset.transformation

import org.apache.flink.api.common.operators.Order
import org.apache.flink.api.scala.ExecutionEnvironment

import scala.collection.mutable.ListBuffer

/**
 *
 */
object BatchFirstNScala {
  def main(args: Array[String]): Unit = {
    val env = ExecutionEnvironment.getExecutionEnvironment
    val data = ListBuffer[Tuple2[Int, String]]()
    data.append((2, "zs"))
    data.append((4, "ls"))
    data.append((3, "ww"))
    data.append((1, "aw"))
    data.append((1, "xw"))
    data.append((1, "mw"))

    import org.apache.flink.api.scala._
    val text: DataSet[(Int, String)] = env.fromCollection(data)

    text.first(4).print()
    println("======================")

    //以第一列分组，获取每组前两个元素
    text.groupBy(0).first(2).print()
    println("======================")

    //分组排序取topN
    // 第一列分组，再根据第二列进行组内排序，每组取前两个数字。
    text.groupBy(0).sortGroup(1, Order.DESCENDING).first(2).print()


  }

}
