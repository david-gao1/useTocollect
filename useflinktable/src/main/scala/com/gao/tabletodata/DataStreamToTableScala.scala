package com.gao.tabletodata

import org.apache.flink.streaming.api.scala.{DataStream, StreamExecutionEnvironment}
import org.apache.flink.table.api.EnvironmentSettings
import org.apache.flink.table.api.bridge.scala.StreamTableEnvironment

/**
 * datastream转换为view视图或者是table
 */
object DataStreamToTableScala {
  def main(args: Array[String]): Unit = {
    //获取tableEnv
    val streamExeEnv = StreamExecutionEnvironment.getExecutionEnvironment
    val streamEnvSet = EnvironmentSettings.newInstance().useBlinkPlanner().inStreamingMode().build()
    val streamEnv = StreamTableEnvironment.create(streamExeEnv, streamEnvSet)

    //获取datastream
    import org.apache.flink.api.scala._
    val text: DataStream[(Int, String)] = streamExeEnv.fromCollection(Array((1, "jack"), (2, "tom"), (3, "mack")))

    //转为view视图
    import org.apache.flink.table.api._
    streamEnv.createTemporaryView("myView", text, 'id, 'name)//注意：'id,'name 和 $"id", $"name" 这两种写法是一样的效果
    streamEnv.sqlQuery("select * from myView where id > 1").execute().print()

    //转为  table对象
    val table: Table = streamEnv.fromDataStream(text, $"id", $"name")
    table.select($"id", $"name")
      .filter($"id" > 1)
      .execute()
      .print()

  }

}
