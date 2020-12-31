package com.gao.scala


import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.streaming.api.windowing.time.Time

/**
 * 通过Socket实时产生一些单词，
 * 使用Flink实时接收数据，对指定时间窗口内(例如：2秒)的数据进行聚合统计
 * 并且把时间窗口内计算的结果打印出来
 */
object SocketWindowWordCountScala {

  /**
   * 注意：在执行代码之前，需要先在hadoop04机器上开启socket，端口为9001
   */
  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment //获取运行环境
    val text: DataStream[String] = env.socketTextStream("hadoop04", 9001) //获取数据来源

    import org.apache.flink.api.scala._ //引入隐式转化，的原因？？？
    val wc: DataStream[(String, Int)] = text.flatMap(_.split(" ")) //处理数据
      .map((_, 1))
      .keyBy(_._1) //选择分组的元素
      .timeWindow(Time.seconds(2))
      .sum(1) //窗口中指定位置的元素相加

    wc.print().setParallelism(1) //使用一个线程执行打印

    env.execute("SocketWindowWordCountScala") //执行job
  }

}