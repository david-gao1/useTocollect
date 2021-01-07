package com.gao.scala.stream.transformation

import org.apache.flink.streaming.api.functions.co.CoMapFunction
import org.apache.flink.streaming.api.scala.{ConnectedStreams, DataStream, StreamExecutionEnvironment}


/**
 * 只能连接两个流，两个流的数据类型可以不同
 * 应用：可以将两种不同格式的数据统一成一种格式
 */
object StreamConnectScala {

  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    import org.apache.flink.api.scala._
    val text1: DataStream[String] = env.fromElements("user:tom,age:18")
    val text2: DataStream[String] = env.fromElements("user:jack_age:20")
    val connectStream: ConnectedStreams[String, String] = text1.connect(text2)

    val connvalue: DataStream[String] = connectStream.map(new CoMapFunction[String, String, String] {
      override def map1(in1: String): String = {
        in1.replace(",", "-")
      }

      override def map2(in2: String): String = {
        in2.replace("_", "-")
      }
    })//最终还是合成一个类型的流
    connvalue.print().setParallelism(1)

    env.execute("StreamConnectScala")
  }

}
