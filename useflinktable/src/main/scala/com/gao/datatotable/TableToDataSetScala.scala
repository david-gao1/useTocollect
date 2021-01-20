package com.gao.datatotable

import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.table.api.bridge.scala.BatchTableEnvironment
import org.apache.flink.types.Row


object TableToDataSetScala {
  def main(args: Array[String]): Unit = {
    //获取BatchTableEnvironment
    val bbEnv = ExecutionEnvironment.getExecutionEnvironment
    val bbTableEnv = BatchTableEnvironment.create(bbEnv)

    //创建输入表
    bbTableEnv.executeSql("" +
      "create table myTable(\n" +
      "id int,\n" +
      "name string\n" +
      ") with (\n" +
      "'connector.type' = 'filesystem',\n" +
      "'connector.path' = 'D:\\data\\source',\n" +
      "'format.type' = 'csv'\n" +
      ")")
    //获取table
    val table = bbTableEnv.from("myTable")



    //将table转换为DataSet
    import org.apache.flink.api.scala._
    val text: DataSet[Row] = bbTableEnv.toDataSet[Row](table)
    text.map(row => (row.getField(0).toString.toInt, row.getField(1).toString))
      .print()


  }

}
