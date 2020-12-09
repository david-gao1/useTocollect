package com.demo


import org.apache.spark.{SparkConf, SparkContext}

/**
 * 需求：单词计数
 * Created by xuwei
 */
object WordCountScala {

  def main(args: Array[String]): Unit = {
    //第一步：创建SparkContext
    val conf = new SparkConf()
    conf.setAppName("WordCountScala")//设置任务名称
      .setMaster("local")//local表示在本地执行
    val sc = new SparkContext(conf)


    //第二步：加载数据
    val linesRDD = sc.textFile("文档/训练资料/wc")

    //第三步：对数据进行处理
    linesRDD.flatMap(_.split(" ")) //截取数据为新的流
      .map((_, 1)) //修改数据格式
      .reduceByKey(_+_) //将key相同的元素进行聚合
      .foreach(wordCount=>println(wordCount._1+"--"+wordCount._2)) //触发执行：打印处理后的数据

    //第四步：停止SparkContext
    sc.stop()
  }

}
