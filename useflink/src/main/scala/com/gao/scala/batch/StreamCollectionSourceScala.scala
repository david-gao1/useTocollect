package com.gao.scala.batch

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}

/**
 * 基于collection的source的使用
 * 注意：这个source的主要应用场景是模拟测试代码流程的时候使用

 */
object StreamCollectionSourceScala {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    import org.apache.flink.api.scala._
    val text: DataStream[Int] = env.fromCollection(Array(1, 2, 3, 4, 5))
    text.print().setParallelism(1)
    env.execute("StreamCollectionSourceScala")

  }

}
