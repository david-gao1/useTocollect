package com.gao.scala.batch.dataset.transformation

import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}

/**
 * 内连接
 */
object BatchJoinScala {
  def main(args: Array[String]): Unit = {
    //source：
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    import org.apache.flink.api.scala._
    val data1: DataSet[(Int, String)] = env.fromCollection(Array((1, "jack"), (2, "tom")))
    val data2: DataSet[(Int, String)] = env.fromCollection(Array((1, "bj"), (2, "sh")))

    //transformation：对两份数据实现join操作。
    //类似于on fileda=filedb的效果
      //where:指定左边的数据集中参与比较的元素角标
      //equalTo：指定右边数据集中参与比较的元素角标
    data1.join(data2).where(0)
      .equalTo(0) {
        (first, second) => {
          (first._1, first._2, second._2)
        }
      }.print()
  }
}
