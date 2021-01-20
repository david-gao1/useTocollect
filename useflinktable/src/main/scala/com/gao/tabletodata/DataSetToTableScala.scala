package com.gao.tabletodata

import org.apache.flink.api.scala.ExecutionEnvironment
import org.apache.flink.table.api.bridge.scala.BatchTableEnvironment


object DataSetToTableScala {
  def main(args: Array[String]): Unit = {
    //获取batchtableEnv
    val exeEnv: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    val batchTableEnv: BatchTableEnvironment = BatchTableEnvironment.create(exeEnv)

    //获取dataset
    import org.apache.flink.api.scala._
    val text: DataSet[(Int, String)] = exeEnv.fromCollection(Array((1, "jack"), (2, "tom"), (3, "mack")))

    //1\转为视图
    import org.apache.flink.table.api._
    batchTableEnv.createTemporaryView("datasetView", text, $"id", $"name")
    batchTableEnv.sqlQuery("select * from datasetView where id > 1").execute().print()


    //2\转为table对象
    val table: Table = batchTableEnv.fromDataSet(text, $"id", $"name")
    table.select($"id", $"name").filter($"id" > 1).execute().print()
  }

}
