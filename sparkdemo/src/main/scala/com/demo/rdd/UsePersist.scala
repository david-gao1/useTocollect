package scala.com.demo.rdd

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * 使用spark的持久化
 */
object UsePersist {
  def main(args: Array[String]): Unit = {
    val sc: SparkContext = CreateRdd.getSparkContext
    val dataRDD: RDD[String] = sc.textFile("文档/训练资料/count").cache()

    var start_time: Long = System.currentTimeMillis()
    var count: Long = dataRDD.count()
    println(count)
    var end_time: Long = System.currentTimeMillis()
    println("第一次耗时：" + (end_time - start_time))

    start_time = System.currentTimeMillis()
    count = dataRDD.count()
    println(count)
    end_time = System.currentTimeMillis()
    println("第二次耗时：" + (end_time - start_time))

    sc.stop()
  }
}