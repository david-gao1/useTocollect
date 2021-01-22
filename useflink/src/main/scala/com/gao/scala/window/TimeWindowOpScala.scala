package com.gao.scala.window

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.windowing.time.Time

/**
 * timewindow的使用
 * 1、滑动
 * 2、滚动
 */
object TimeWindowOpScala {
  def main(args: Array[String]): Unit = {
    //流的执行环境
    val env = StreamExecutionEnvironment.getExecutionEnvironment
    val streamText: DataStream[String] = env.socketTextStream("hadoop04", 9001)

    //rollingWindow(streamText)

    slidingWindow(streamText)

    env.execute("TimeWindowOpScala")
  }

  private def rollingWindow(streamText: DataStream[String]) = {
    import org.apache.flink.api.scala._
    streamText.flatMap(_.split(" "))
      .map((_, 1))
      .keyBy(0)
      .timeWindow(Time.seconds(10))
      .sum(1).print()
  }

  private def slidingWindow(streamText: DataStream[String]) = {
    import org.apache.flink.api.scala._
    streamText.flatMap(_.split(" "))
      .map((_, 1))
      .keyBy(0)
      .timeWindow(Time.seconds(10), Time.seconds(5))
      .sum(1).print()
  }
}
