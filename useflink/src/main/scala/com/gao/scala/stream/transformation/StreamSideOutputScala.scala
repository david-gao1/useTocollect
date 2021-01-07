package com.gao.scala.stream.transformation

import org.apache.flink.streaming.api.functions.ProcessFunction
import org.apache.flink.streaming.api.scala.{DataStream, OutputTag, StreamExecutionEnvironment}
import org.apache.flink.util.Collector

/**
 * 使用sideoutput切分流，
 * 二次切分
 */
object StreamSideOutputScala {
  def main(args: Array[String]): Unit = {
    val env = StreamExecutionEnvironment.getExecutionEnvironment

    import org.apache.flink.api.scala._
    val text = env.fromCollection(Array(1, 2, 3, 4, 5, 6, 7, 8, 9, 10))

    //创建OutputTag建立分类标签，表示SideOutput操作符
    val outputTag1 = new OutputTag[Int]("even") {}
    val outputTag2 = new OutputTag[Int]("odd") {}

    //process属于flink里的低级api
    val outputStream: DataStream[Int] = text.process(new ProcessFunction[Int, Int] {
      override def processElement(value: Int, ctx: ProcessFunction[Int, Int]#Context, out: Collector[Int]): Unit = {
        if (value % 2 == 0) {
          ctx.output(outputTag1, value)
        } else {
          ctx.output(outputTag2, value)
        }
      }
    })

    //根据标签获取流
    val evenStream = outputStream.getSideOutput(outputTag1)
    val oddStream = outputStream.getSideOutput(outputTag2)
    //evenStream.print().setParallelism(1)


    //对evenStream流进行二次切分
    val outputTag11 = new OutputTag[Int]("low") {} //保存小于等五5的数字
    val outputTag12 = new OutputTag[Int]("high") {} //保存大于5的数字

    val subOutputStream = evenStream.process(new ProcessFunction[Int, Int] {
      override def processElement(value: Int, ctx: ProcessFunction[Int, Int]#Context, out: Collector[Int]): Unit = {
        if (value <= 5) {
          ctx.output(outputTag11, value)
        } else {
          ctx.output(outputTag12, value)
        }
      }
    })
    //获取小于等于5的数据流
    val lowStream = subOutputStream.getSideOutput(outputTag11)
    //获取大于5的数据流
    val highStream = subOutputStream.getSideOutput(outputTag12)

    lowStream.print().setParallelism(1)


    env.execute("StreamSideOutputScala")
  }

}