package com.gao.scala


import org.apache.flink.api.scala.{DataSet, ExecutionEnvironment}

/**
 * 需求：统计指定文件中单词出现的总次数
 */
object BatchWordCountScala {
  def main(args: Array[String]): Unit = {
    //获取执行环境
    val env: ExecutionEnvironment = ExecutionEnvironment.getExecutionEnvironment

    /**
     * 需要开启hdfs，和添加hdfs-client的依赖
     */
    val inputPath = "hdfs://hadoop01:9000/hello.txt"
    val outPath = "hdfs://hadoop01:9000/out.txt"

    //读取文件中的数据

    val text: DataSet[String] = env.readTextFile(inputPath)
    //数据处理
    import org.apache.flink.api.scala._
    val wc: DataSet[(String, Int)] = text.flatMap(_.split(" "))
      .map((_, 1))
      .groupBy(0)
      .sum(1)
      .setParallelism(1) //设置平行度为1，是为了输出到一个文件中
    //将结果保存到文件中
    wc.writeAsCsv(outPath, "\n", " ")
    //执行程序
    env.execute("BatchWordCountScala")
  }
}
