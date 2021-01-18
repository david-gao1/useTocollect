package com.gao.scala.batch.dataset.transformation

import org.apache.flink.api.scala.ExecutionEnvironment

import scala.collection.mutable.ListBuffer

/**
 * MapPartition的使用：一次处理一个分区的数据
 */
object BatchMapPartitionScala {
  def main(args: Array[String]): Unit = {
    //datasource:
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment
    import org.apache.flink.api.scala._
    val text: DataSet[String] = env.fromCollection(Array("hello you", "hello me", "hello haha"))

    //transformation:每次处理一个分区的数据
    text.mapPartition(it => {
      /**
       * 可以在此处创建数据库连接，建议将这块代码放在try-catch代码块中，
       * 此时每个分区获取一个数据库连接，不需要没处理一条数据就获取一次连接，性能较高
       */
      val stringBufffer = ListBuffer[String]()
      it.foreach(line => {
        val words = line.split(" ")
        for (word <- words) {
          stringBufffer.append(word)
        }
      })
      stringBufffer
      //关闭数据连接
    }).print()

    //注意：正对的是datasetapi，执行了count、collect、print，就不需要execute了。
    //env.execute("BatchMapPartitionScala")
  }
}
