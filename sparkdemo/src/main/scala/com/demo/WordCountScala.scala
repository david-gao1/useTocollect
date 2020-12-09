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

    //第三步：对数据进行切割，把一行数据切分成一个一个的单词
    linesRDD.flatMap(_.split(" "))
      .map((_, 1))
      .reduceByKey(_+_)
      .foreach(wordCount=>println(wordCount._1+"--"+wordCount._2))

    //第四步：停止SparkContext
    sc.stop()
  }

}
