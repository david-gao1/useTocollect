package com.gao.datatotable

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.table.api.EnvironmentSettings
import org.apache.flink.table.api.bridge.scala.StreamTableEnvironment
import org.apache.flink.types.Row

object TableToDataStreamScala {
  def main(args: Array[String]): Unit = {
    //创建执行环境
    val exeEnv = StreamExecutionEnvironment.getExecutionEnvironment
    val streamingEnvSet: EnvironmentSettings = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build()
    val streamTableEnv: StreamTableEnvironment = StreamTableEnvironment.create(exeEnv, streamingEnvSet)


    //创建输入表
    streamTableEnv.executeSql("" +
      "create table myTable(\n" +
      "id int,\n" +
      "name string\n" +
      ") with (\n" +
      "'connector.type' = 'filesystem',\n" +
      "'connector.path' = 'D:\\data\\source',\n" +
      "'format.type' = 'csv'\n" +
      ")")
    //获取table
    val table = streamTableEnv.from("myTable")

    //table转datastream
    //    //如果只有新增(追加)操作，可以使用toAppendStream
    import org.apache.flink.api.scala._
    //    val appStream = streamTableEnv.toAppendStream[Row](table)
    //    appStream.map(row=>(row.getField(0).toString.toInt,row.getField(1).toString))
    //      .print()

    //如果有增加操作，还有删除操作，则使用toRetractStream
    val retStream = streamTableEnv.toRetractStream[Row](table)
    retStream.map(tup => {
      val flag = tup._1
      val row = tup._2
      val id = row.getField(0).toString.toInt
      val name = row.getField(1).toString
      (flag, id, name)
    }).print()

    //注意：将table对象转换为DataStream之后，就需要调用StreamExecutionEnvironment中的execute方法了
    exeEnv.execute("TableToDataStreamScala")


  }

}
